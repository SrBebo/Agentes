#!/usr/bin/env python
# coding: utf-8

# In[1]:


##Permite leer el archivo .ipynb
from keras.models import Sequential
from keras.layers import Dense
from tensorflow import keras
import sys
from keras.models import load_model
from sklearn.preprocessing import MinMaxScaler
import pandas as pd
from sklearn import preprocessing
from sklearn.preprocessing import LabelEncoder


# In[2]:


##Crea funcion para llamar al modelo
def predecir_Precio(info):
    ##Cargar el modelo
    modeloPrecio= load_model('C:\\Users\\OMEN\\Documents\\NetBeansProjects\\ExamenAI\\src\\modelo\\public_cars.h5')##Carga nuestro .h5 que es el modelo entrenado
    resultado = modeloPrecio.predict(info)
    return resultado[0][0]


# In[3]:

dataframe = pd.read_csv('C:\\Users\\OMEN\\Documents\\NetBeansProjects\\ExamenAI\\src\\modelo\\public_cars.csv')
encoder = LabelEncoder()
dataframe = dataframe.fillna(dataframe.mean())
dataframe["manufacturer_name"] = encoder.fit_transform(dataframe["manufacturer_name"])
dataframe["model_name"] = encoder.fit_transform(dataframe["model_name"])
dataframe["transmission"] = encoder.fit_transform(dataframe["transmission"])
dataframe["color"] = encoder.fit_transform(dataframe["color"])
dataframe["engine_fuel"] = encoder.fit_transform(dataframe["engine_fuel"])
dataframe["engine_has_gas"] = encoder.fit_transform(dataframe["engine_has_gas"])
dataframe["engine_type"] = encoder.fit_transform(dataframe["engine_type"])
dataframe["body_type"] = encoder.fit_transform(dataframe["body_type"])
dataframe["has_warranty"] = encoder.fit_transform(dataframe["has_warranty"])
dataframe["state"] = encoder.fit_transform(dataframe["state"])
dataframe["drivetrain"] = encoder.fit_transform(dataframe["drivetrain"])
dataframe["feature_0"] = encoder.fit_transform(dataframe["feature_0"])
dataframe["feature_1"] = encoder.fit_transform(dataframe["feature_1"])
dataframe["feature_2"] = encoder.fit_transform(dataframe["feature_2"])
dataframe["feature_3"] = encoder.fit_transform(dataframe["feature_3"])
dataframe["feature_4"] = encoder.fit_transform(dataframe["feature_4"])
dataframe["feature_5"] = encoder.fit_transform(dataframe["feature_5"])
dataframe["feature_6"] = encoder.fit_transform(dataframe["feature_6"])
dataframe["feature_7"] = encoder.fit_transform(dataframe["feature_7"])
dataframe["feature_8"] = encoder.fit_transform(dataframe["feature_8"])
dataframe["feature_9"] = encoder.fit_transform(dataframe["feature_9"])
dataframe = dataframe.drop('manufacturer_name',axis=1)
dataframe = dataframe.drop('color',axis=1)
dataframe = dataframe.drop('engine_fuel',axis=1)
dataframe = dataframe.drop('engine_has_gas',axis=1)
dataframe = dataframe.drop('engine_type',axis=1)
dataframe = dataframe.drop('state',axis=1)
dataframe = dataframe.drop('duration_listed',axis=1)
X=dataframe.drop(['price_usd'],axis=1)
y = dataframe['price_usd']
minmaxscaler = MinMaxScaler()
minmaxscaler.fit(X)
X = minmaxscaler.transform(X)
datos=[e1 for e1 in list(map(str, sys.argv[1:]))]
carro=([[503,1,245000,2006,1.6,2,0,1,1,0,0,0,0,0,0,0,0,0]])
carro = minmaxscaler.transform(carro)
res=predecir_Precio(carro)
print(res)
