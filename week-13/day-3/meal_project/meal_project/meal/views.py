from django.http.response import HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.http import HttpResponse, JsonResponse
from .forms import MealForm
from .models import Meal
from django.views import View
from django.views.generic import TemplateView
from django.db import models    
from meal import forms
from django.urls import reverse_lazy
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from .serializers import MealSerializer
from datetime import datetime
from django.db.models import Sum


# TODO
# Get sum of the calories for a single day (GET request)                        TBD
# vytvorit serializery pro mealplan ukol                                        DONE
# otestovat alespon 1 endpoint - rest_framework.test.APIClient (optional)       TBD


# List all meals (GET request), function based view
def home(request):
    context = {
        'meals': Meal.objects.all(),
        'function_view': 'yes'
    }
    return render(request, 'meal/home.html', context)

# def meal_detail(request, id):
#     context = {
#         'meals': Meal.objects.all().filter(id=id),
#         'function_view': 'yes'
#     }
#     return render(request, 'meal/home.html', context)

    
# List all meals (GET request), class based view
class MealsView(View):
    def get(self, request):
        context = {
            'meals': Meal.objects.all(),
            'class_view': 'yes'
        }
        return render(request, 'meal/home.html', context)

# Get a single meal by ID (GET request) deprecated by PUT request
class MealView(View):
    def get(self, request, id):
        context = {
            'meals': Meal.objects.filter(id=id),
            'class_view': 'yes'
        }
        return render(request, 'meal/home.html', context)

# Add new meals (GET form, POST request)
class MealViewTemplate(TemplateView):
    template_name = 'meal/create.html'
    form_class = MealForm

    def get(self, request):
        return render(request, self.template_name, {'form': self.form_class})

    def post(self, request):   
        form = MealForm(request.POST)
        if form.is_valid():
            meal = form.save()
            meal.save()
            return HttpResponseRedirect(reverse_lazy('meal-home'))
        
        
# Update meals (PUT request)
def meal_update(request, id):
    # meal = get_object_or_404(Meal, pk=id)
    meal = Meal.objects.get(pk=id)

    if request.method == "POST":
        form = MealForm(request.POST, instance=meal)
        if form.is_valid():
            meal = form.save()
            meal.save()
        return HttpResponseRedirect(reverse_lazy('meal-home'))  
    else:
        form = MealForm(instance = meal)
        template_name = 'meal/update.html'
        return render(request, template_name, {'form': form})


# REST template implementation

# Delete meals by ID (DELETE request)    
def meal_delete(request, id):
    meal = Meal.objects.get(pk=id)
    meal.delete()
    return HttpResponseRedirect(reverse_lazy('meal-home')) 
    
# List all Meals or create new one   
@csrf_exempt
def model_list(request):
    if request.method == 'GET':
        models = Meal.objects.all()
        serializer = MealSerializer(models, many=True)
        return JsonResponse(serializer.data, safe=False)
    
    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = MealSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)
    
 
# Retrive, Update, Delete meal
@csrf_exempt
def meal_detail(request, pk):
    try:
        meal = Meal.objects.get(pk=pk)
    except Meal.DoesNotExist:
        return HttpResponse(status=404)
    
    if request.method == 'GET':
        serializer = MealSerializer(meal)
        return JsonResponse(serializer.data)
    
    elif request.method == 'PUT':
        data = JSONParser().parse(request)
        serializer = MealSerializer(meal, data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data)
        return JsonResponse(serializer.errors, status=400)
    
    elif request.method == 'DELETE':
        meal.delete()
        return HttpResponse(status=204)
    
@csrf_exempt
def model_list(request):
    if request.method == 'GET':
        models = Meal.objects.all()
        serializer = MealSerializer(models, many=True)
        return JsonResponse(serializer.data, safe=False)
    
def show_calories_per_day(request):
    day = request.GET.get('day')
    day = datetime.strptime(day,'%b. %d, %Y')
    calories = Meal.objects.filter(date=day).aggregate(Sum('calories'))
    context = {
            'calories': calories['calories__sum'],
            'date': day.strftime('%b. %d, %Y')
        }
    return render(request, 'meal/calories-per-day.html', context)


