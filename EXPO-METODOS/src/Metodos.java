import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Metodos {
	
	//funcion: Una cadena de texto que representa una expresión matemática o una función matemática que se desea evaluar.
	//x: Un valor numérico de tipo double que se utiliza como entrada para la expresión matemática.
    public double funcion(String expresion, double h) {  	
    	//Se crea un objecto de tipo ExpressionBuilder en el cual pasamos como parametro a la cadena expresionMatematica   
    	Expression valorFuncion = new ExpressionBuilder(expresion) 
                .variables("x") //Se crea el tipo de variable, que sera remplazada por un valor.
                .build() //Se cosntruye la expresion 
                .setVariable("x", h); 
        double resultado = valorFuncion.evaluate(); 
        return resultado;
    }
    
    
    //
    //Formula error relativo
    public  double errorRelativo(double actual, double anterior) { 
        double resultado = Math.abs( ( (actual-anterior) / actual )*100 );
        return resultado;
    }
    //Formula secante (a = xi, b = xi-1)
    public double metodoSecante(String funcion, double a, double b) { 
        double resultado = a - ( funcion(funcion, a)*(b-a) ) / ( funcion(funcion, b)-funcion(funcion, a) ); //resultado (c) = xi+1
        return resultado;
    }
    
}
