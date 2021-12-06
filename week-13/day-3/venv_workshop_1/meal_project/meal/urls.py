from django.urls import path
from . import views
from meal.views import MealView, MealViewTemplate

urlpatterns = [
    path('', views.home, name='meal-home'),
    # path('<id>/', views.mealDetail),
    path('<int:id>/', MealView.as_view()),
    path('create/', MealViewTemplate.as_view(), name='create'),
    path('update/<int:id>/', views.mealUpdate, name='update'),
    path('delete/<int:id>/', views.mealDelete, name='delete')

    
]
