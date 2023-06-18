import java.util.ArrayList;
import javax.swing.JOptionPane;
public class TablaHash {
    public static void main(String[] args) {
        //VARIBLES A UTILIZAR
        int dato = 0, menu = 0, tam = 0, resul, aux=0, RM=0;
        ArrayList<Integer> dp = new ArrayList<>();
        //REPETIR MIENTRASEL TAMAÑO DE LA TABLA SEA MENOR O IGUAL A 0
        while(tam <= 0){
            try{//INTENTAR
            //PEDIR EL TAMAÑO DE LA TABLA
            tam = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITA EL NÚMERO DE CASILLAS:"));
            //SI EL TAMAÑA DADOES MENOR O IGUAL A CERO SE DEBE DE INGREAR UN VALOR MAYOR A CERO
            if(tam <= 0){
                //SE INDICA CON EL JOOPTION
                JOptionPane.showMessageDialog(null, "DIGITE UNA VALOR MAYOR A CERO!");
            }
            //CAPTURANDO EL TIPO DE ERROR (LETRAS POR NUMEROS)
            }catch(NumberFormatException ex){
                //SE INDICA CON JOPTION
                JOptionPane.showMessageDialog(null, "SOLO SE ADMITEN NÚMEROS!");
            }
        }
        //SE CREA INSTANCIA DE ARREGLO DE LS CLASE "Hash" PARA CREAR UN OBJETO LLAMADO "TablaHash"
        //QUE ESTE OBJETO SERA NESTRO ARREGLO A TABLA HASH PARA TRABAJAR DESDE AQUI EN LA MAIN
        Hash[] tablaHash = new Hash[tam];
        //SE CREA INSTANCIA PARA ACCEDER AL METODO DE SOLUCION DE LAS COLISIONES CON EL METODO DE ENCADENAMIENTO ENLAZADO
        Hash listaEnlazada = new Hash();
        //CON ESTE CICLO FOR ESTAMOS HACIENDO EL RECORRIDO DE NUESTRA TABLA HASH PARA ASIGNARE O
        //INDICARLE QUE SU ESTADO ESTA VACIO DESDE EL ESPACIO CERO HASTA SU ULTIMO ESPACIO
        for(int i=0; i<tam;i++){
            tablaHash[i] = new Hash();
            tablaHash[i].estado=0;
        }
        /*TENEMOS EL CICLO WHILE QUE RPEIRA TODO LO QUE ESTE EN EL MENU PRINCIPAL*/
        while(RM == 0){//CONDICION PARA QUE SE REPITA EL CICLO
            //INICIANDO EL TRY CATCH PARA DETECETAR ERRORES EN EL MENU PRINCIPAL
            try{//INTENTAR
                //SE PIDE LA OPCION DEL MENU
                menu = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    " 1.- INSERTAR \n"
                    + " 2.- BUSCAR \n"
                    + " 3.- ELIMINAR \n"
                    + " 4.- SALIR"));
                //SE COMPRUEBA QUE SE HALLA DADO UNA OPCION VALIDA DEL MENU-
                //YA QUE SI SE DA UN VALOR NEGATIVO TRUENA EL PROGRAMA
                if(menu <= 0){
                    //SE INDICA CON JOPTION
                    JOptionPane.showMessageDialog(null, "DIGITE UNA VALOR MAYOR A CERO!");
                }
                //CAPTURANDO EL TIPO DE ERROR (LETRAS POR NUMEROS)
                }catch(NumberFormatException ex){
                    //SE INDICA CON JOPTION
                    JOptionPane.showMessageDialog(null, "SOLO SE ADMITEN NÚMEROS!");
                }
            /*SEGUN LO QUE VALGA MENÚ SE EJECUTARA EL CASO CORRESPONDIENTE (CON EL SWITCH)*/
            switch(menu){
                case 1://CASE 1
                    aux = dato%tam;//SE HACE ESTA ASIGNACION PARA PODER HACER UNA COMPARACION DESPUES..
                    dato = -1;//SE LE ASIGNA ESTE VALOR PARA PODER ACCEDER AL CICLO WHILE
                    while(dato < 0){//CONDICION DEL CICLO PARA PODER ACCEDER
                        //INICIANDO TRY CATCH, PARA DETECCION DE ERRORES
                        try{//INTENTAR
                            int Valoringresar = 0;//VARIABLE PARA USAR EN CICLO
                            while(Valoringresar == 0){//CONDICION PARA ACCEDER AL CICLO
                                //SE PIDE EL VALOR DEL DATO CON JOPTION
                                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITA EL ENTERO A INGRESAR:"));
                                //SE COMPARA SI EL DATO ES NEGATIVO, DE SER ASI TRUENA EL PROGRAMA
                                if(dato < 0){//CONDICION
                                    //SE INDICA CON JOPTION
                                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN DAR NÚMEROS NEGATIVOS!");
                                    //CUMPLIMOS LA CONDION DEL CICLO PARA VOLVER A PEDIR EL DATO
                                    Valoringresar = 0;
                                }else{//CASO CONTRARIO
                                    //ROMPEMOS EL BUCLE
                                    Valoringresar = 1;
                                }
                            }
                        /*EN LA VARIABLE RESUL VAMOS A ALMACENAR LO QUE NOS RETORNE EL METODO DE INSERTAR
                          PARA POSTERIORMENTE HACER UNAS COMPARACIONES CON RESULT*/    
                        resul = Hash.insertar(tablaHash, tam, dato);
                        if(aux != dato%tam){//COMPARACION DE SI AUX ES DIFERENTE DEL DATO
                                //DE SER ASI SE LLAMAN METODOS
                                listaEnlazada.lETemp();
                                dp.clear();
                                listaEnlazada.mostrarResultado();
                            }
                        /*SI EL VALOR DE RESULT ES IGUAL A 1....*/
                        if(resul == 1){
                            //SIGNIFICA QUE HA OCURRIDO UNA COLISION
                            JOptionPane.showMessageDialog(null, "HA OCURRIDO UNA COLISIÓN, AGREGANDO DATO A SU LISTA ENLAZADA...");
                            //LLAMAMOS EL METODO CON EL OBJETO Y LE PASO EL DATO
                            listaEnlazada.agregarAlaListaEnlazada(dato);
                            //MOSTRAMOS EL RESULTADO
                            listaEnlazada.mostrarResultado();
                            dp.add(dato);
                            //CASO CONTRARIO
                        }else{
                            /*SIGNIFICA QUE NO HAY COLISION, POR ENDE EL DATO SE AGREGA NORMALMENTE
                            A LA TABLA HASH LLAMANDO AL METODO CON NUESTRO OBJETO Y DANDOLE SUS PARAMETROS CORRESPONDIETES*/
                            Hash.insertar(tablaHash, tam, dato);
                        }
                        //CAPTURANDO EL TIPO DE ERROR EN EL CATCH (LETRAS POR NUMEROS)
                        }catch(NumberFormatException ex){
                            //INDICANDOLO CON JOPTION
                            JOptionPane.showMessageDialog(null, "NO SE PUEDEN DAR NÚMEROS NEGATIVOS!");
                        }
                    }
                    break;//CIERRE DEL CASE 1
                case 2://CASE 2
                    dato = -1;//ASIGNACION PARA PODER ACCEDER AL CICLO
                    //MIENTRAS DATO SEA MENOR O IGUAL A 0
                    while(dato <= 0){//CONDICION
                        //INICIANDO EL TRY CATCH PARA DETECCION DE ERRORES
                        try{//INTENTAR
                            int valorBuscar = -1;//VARIABLE PARA USAR EN CICLO
                            //MIENTRAS LA VARIABLE "valorBuscar" SEA MENOR A 0 SE REPEIRA... 
                            while(valorBuscar < 0){//CONDICION
                                //PIDIENDO EL VALOR DE DATO CON JOPTION Y SU RESPECTIVA CONVERSION
                                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITA EL ENTERO A BUSCAR: "));
                                //SI EL VALOR DE DATO QUE SE DIO ES MENOR A 0....
                                if(dato < 0){//CONDICION
                                    //SIGNIFICA QUE NO SE PUEDEN DDAR NUMEROS NEGATIVOS
                                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN DAR NÚMEROS NEGATIVOS!");
                                    /*CUMPLIMOS LA CONDICION DEL CICLO PARA VOLVER A PEDIR EL DATO A BUSCAR*/
                                    valorBuscar = -1;
                                }else{//CASO CONTEARIO
                                    //ROMPEMOS EL BUCLE
                                    valorBuscar = 0;
                                }
                            }
                            /*EN LA VARIABLE RESUL VAMOS A ALMACENAR LO QUE NOS RETORNE EL METODO DE BUSCAR
                          PARA POSTERIORMENTE HACER UNAS COMPARACIONES CON RESULT*/  
                            resul = Hash.buscar(tablaHash, tam, dato);
                            //SI LA VARIABLE RESU ES IGUAL A -1
                            if(resul == -1){//CONDICION
                                //SIGNIFICA QUE EL DATO DADO NO SE ENCUENTRA EN LA TABLA HASH, SE INDICA CON JOPTION
                                JOptionPane.showMessageDialog(null, "NO SE ENCONTRÓ EL ENTERO EN LA TABLA HASH, Buscando en la Lista enlazada....");
                                /*AHORA COMO NO SE ENCONTRO ESE DATO EN LA TABLA HASH LO QUE SE HARA ES BUSCAR EN LA LISTA
                                ENLAZADA PARA VER SI SE ENCUENTRA ESE DATO AHI*/
                                for(int i=0;i<dp.size();i++){//INICIALIZACION
                                    if(dp.get(i) == dato){//SE PREGUNTA SI DAO ES IGUAL AL DE LA POSICION "i"
                                        //DE SER ASI RETORNAMOS EL DATO Y SU POSICION CON JOPTION
                                        JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO " + (dato) + " SE ENCONTRÓ EN LA POSICIÓN " + (i+1));
                                    }else{//CASO CONTRARIO...
                                        //SIGNIFICA QUE TAMPOCO SE ENCONTRO EN LA LISTA ENLAZADA, SE INDICA CON JOPTION
                                        JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO " + dato + " NO SE ENCONTRÓ EN LA POSICIÓN: " + i+1);
                                    }
                                }
                            }else{//CASO CONTRARIO
                                /*SIGNIFICA QUE EL DATO SI SE ENCONTRO EN LA TABLA HASH Y REGRESAMOS EL DATO Y SU POSICION CON JOPTION*/
                                JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO " + dato + " SE ENCONTRÓ EN LA POSICIÓN: " + resul);
                            }
                            //CAPTURANDO EL TIPO DE ERROR EN EL CATCH (LETRAS POR NUMEROS)
                        }catch(NumberFormatException ex){
                            //SE INDICA CON JOPTION
                            JOptionPane.showMessageDialog(null, "SOLO SE ADMITEN NÚMEROS!");
                        }
                    }
                    break;//CIERRE DEL CASE 2
                case 3://CASE 3
                    dato = -1;//ASIGNACION PARA PODER ACCEDER AL CICLO
                    while(dato < 0){//CONDICION PARA ACCEDER AL CICLO (DATO TIENE QUE TENER UN VALOR MENOR A 0)
                        //INCIANDO EL TRY CATCH PARA DETENCION DE ERRORES
                        try{//INTENTAR
                            int valorEliminar = -1;//VARIABLE INICIALIZADA PARA USAR EN CICLO
                            /*LA VARIABLE valorEliminar TIENE QUE SER MENOR A 0 PARA PODER ENTRAR AL CICLO*/
                            while(valorEliminar < 0){//CONDICION
                                //PIDIENDO EL VALOR DE DATO CON JOPTION
                                dato = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE EL ENTERO A ELIMINAR"));
                                //SI DATO ES MENOR A 0....
                                if(dato < 0){
                                    //SIGNIFICA QUE NO SE PUEDEN DAR NUMERO NEGATIVOS Y SE INDICA CON JOPTION
                                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN DAR NÚMEROS NEGATIVOS!");
                                    /*CUMPLIMOS LA CONDICION DEL CICLO PARA VOLVER A PEDIR EL DATO*/
                                    valorEliminar = -1;
                                }else{//CASO CONTRARIO
                                    //ROMPEMOS EL BUCLE
                                    valorEliminar = 1;
                                }
                            }
                            /*EN LA VARIABLE RESUL VAMOS A ALMACENAR LO QUE NOS RETORNE EL METODO DE ELIMINAR
                          PARA POSTERIORMENTE HACER UNAS COMPARACIONES CON RESULT*/    
                            resul = Hash.eliminar(tablaHash, tam, dato);
                            //SI LA VARIABLE RESULT RETORNA -1....
                            if(resul == -1){
                                //SIGNIFICA QUE EL ELEMENTO NO SE ENCONTRABA EN LA TABLA HASH
                                JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO NO SE ENCONTRÓ EN LA TABLA HASH");
                            }else{//CASO CONTRARIO
                                //SIGNIFICA QUE EL ELEMENTO SI SE ELIMINO
                                //Y CONCATENMOS LA POSICION CON EL RETORNO DE LA VARIABLE RESUL
                                JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO SE ELIMINÓ DE LA POSICIÓN: " + resul);
                            }
                            //CAPTURANDO EL TIPO DE ERROR EN EL CATCH (LETRAS POR NUMEROS)
                        }catch(NumberFormatException ex){
                            //SE INDICA CON JOPTION
                            JOptionPane.showMessageDialog(null, "SOLO SE ADMITEN NÚMEROS!");
                        }
                    }
                    break;//CIERRE DEL CASE 3
                case 4://CASE 
                    //UN MENJAE DE DESPEDIDA CON JOPTION
                    JOptionPane.showMessageDialog(null, "HASTA LA PRÓXIMA....");
                    RM = 1;//ROMPEMOS EL BUCLE DEL MENU PRINCIPAL
                    break;//CIERRE DEL CASE 4
            }
        }        
    }
}