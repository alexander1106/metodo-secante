import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.text.DecimalFormat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Logica {
    public static void main(String[] args) {
        
    	Scanner teclado = new Scanner(System.in);
    	String funcion;        
    	Metodos metodos  = new Metodos();

    	//Declaracion de variables.
        double x2,x1,x3=0,errorPermitido ,error = 0, errorAnterior = 0,calculoError = 0;
        int iteraciones = 0;
                System.out.println("Escriba la funcion: ");
        funcion = teclado.next();
        
         // -> x1       
        System.out.println("Inserte el primer límite: ");
        x1 = teclado.nextDouble();

        // -> x2 
        System.out.println("Inserte el segundo límite: ");
        x2 = teclado.nextDouble();

    
        // máximo error permitido
        System.out.println("Máximo error permitido: ");
        errorPermitido = teclado.nextDouble();
               
        do {       
            errorAnterior = error; //guardar error anterior
            x3 = metodos.metodoSecante(funcion, x2, x1); //calcular xi+1
            error = x3; //guardar error actual            
            calculoError = metodos.errorRelativo(error, errorAnterior); //calcular error relativo
            iteraciones++;
            
            System.out.println("-------------------------");
            System.out.println();           
            System.out.println("Itersacion número "+  iteraciones);
            System.out.println("X1 = "+x1);
            System.out.println("X2 = "+x2);
            System.out.println();           
            System.out.println("F(X1) = " + metodos.funcion(funcion, x1));
            System.out.println("F(X2) = " + metodos.funcion(funcion, x2));
            System.out.println();           
            System.out.println(x1+" // "+x2);
            System.out.println("Error = "+ calculoError+"%");           
            //cambio de columnas para la siguiente iteración
            
            x1 = x2;
            x2 = x3;           
            
        } while (calculoError > errorPermitido && x2 != x1); 
        
        //imprimir resultados
        System.out.println("-----------------------");
        System.out.println("El numero total de Iteraciones es = "+iteraciones);
        System.out.println("Lo que vale la raiz = "+x3);
        System.out.println("Valor de la raiz en f = "+metodos.funcion(funcion, x3));                 
    }
}