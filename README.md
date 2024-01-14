La integración numérica es una herramienta esencial que se usa en la ciencia y en la 
ingeniería para obtener valores aproximados de integrales definidas que no pueden 
calcularse analíticamente, es decir, cuando se nos hace imposible mediante métodos analíticos 
determinar la anti derivada o integral requerida, aun cuando se trate de integrales 
aparentemente sencillas, que son imposibles de resolver con el Teorema Fundamental del 
Cálculo. En estos casos, debemos de recurrir a la integración numérica permite obtener 
aproximaciones bastantes exactas, utilizando sólo las operaciones más simples de la 
aritmética, donde además se requiere de una secuencia de operaciones algebraicas que 
producen la aproximación al problema matemático.
Es por lo cual en el proyecto describe la regla del trapecio y a la regla de 
Simpson, donde para el método del trapecio se divide en sub áreas la curva, como un pequeño 
trapecio y en 1/3 se conecta grupos sucesivos de tres puntos sobre la curva.
Por lo tanto para el proceso de solución de problemas de integración numérica se realizo un 
software aplicando el lenguaje Java y métodos de programación, donde identifica el 
problema, sus limitaciones y las variables que intervienen, formulando una solución 
denominada también algoritmo, expresándola en una serie detallada de operaciones.

se decriben las siguientes funciones:
a) calculode_simpson()
b) calculode_trapecio()
c) datos_simpson()
d) datos_trapecio()
e) class FuncionMetNumericos 

EJEMPLOS:

trapecio x sin (x) a=0 b=1 n=1 h =1 sumatoria de la integral= 0.420735
tapecio  3/(4-x)  a=0 b=2 n=4  sumatoria de la integral=2.09108
trapecio  1/(sqrt (x^(2)-4))   a=3  b=5  n=8 sumatoria de la integral=0.6038
trapecio  x^(3)/(1+x^(1/2))  a=1 b=2 n=1  sumatoria de la integral=1.906854
simpson  3/(4-x)  a=0 b=2 n=6    sumatoria de la integral =1.80684
simpson= x^(3)/(1+x^(1/2))  a=1 b=2 n=2  sumatoria de la integral=1.646970
simpson  (x^(2)+8)^(1/3)   a=1   b=2.5    sumatoria de la integral=3.3543
