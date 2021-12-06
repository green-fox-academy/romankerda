from django.http.response import HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.http import HttpResponse
from .forms import MealForm
from .models import Meal
from django.views import View
from django.views.generic import TemplateView
from django.db import models    
from meal import forms
from django.urls import reverse_lazy



# TODO
# Get sum of the calories for a single day (GET request)
# vytvorit serializery pro mealplan ukol
# otestovat alespon 1 endpoint - rest_framework.test.APIClient (optional)


# List all meals (GET request), function based view
def home(request):
    context = {
        'meals': Meal.objects.all(),
        'function_view': 'yes'
    }
    return render(request, 'meal/home.html', context)

def meal_detail(request, id):
    context = {
        'meals': Meal.objects.all().filter(id=id),
        'function_view': 'yes'
    }
    return render(request, 'meal/home.html', context)

    
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
def mealUpdate(request, id):
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


# Delete meals by ID (DELETE request)    
def mealDelete(request, id):
    meal = Meal.objects.get(pk=id)
    meal.delete()
    return HttpResponseRedirect(reverse_lazy('meal-home')) 
    





