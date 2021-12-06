from django.urls import path
from . import views
from meal.views import MealView, MealViewTemplate, MealsView

urlpatterns = [
    path('', views.home, name='meal-home'),
    path('class-view/', MealsView.as_view()),
    path('create/', MealViewTemplate.as_view(), name='create'),
    path('update/<int:id>/', views.meal_update, name='update'),
    path('delete/<int:id>/', views.meal_delete, name='delete'),
    path('json-list/', views.model_list),
    path('json/<int:pk>/', views.meal_detail),
    path('calories-per-day/', views.show_calories_per_day)
   
]
