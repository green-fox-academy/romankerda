from django.db import models

class Meal(models.Model):
    name = models.CharField(max_length=70)
    calories = models.IntegerField()
    date = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.name


