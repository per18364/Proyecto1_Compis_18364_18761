from django.db import models


class Code(models.Model):
    code = models.CharField(max_length=1000)

    def __str__(self):
        return self.code

# Create your models here.
