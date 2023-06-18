import javax.swing.JOptionPane;//IMPORTANDO LA LIBRERIA JOPTION
public class Hash<tope> {
    protected ClsNodo inicio, fin;//VARIABLE DE TIPO NODO
    //INICIANDO LA CABECERA EN VACIO O NULL
    ClsNodo<tope> cabecera = null;
	int tamano;
        //CONSTRUCTOR 
	public Hash(){
            //INICIALIZACION
            tamano=0;
            inicio=null;
            fin=null;
	}
    private int dato;//DATO A INGRESAR A LA TABLA HASH
    int estado;//ESTADO DE LA RESPECTIVA CASILLA:
    //estado = 0 -> esapcio vacio
    //estado = 1 -> esapcio eliminado
    //estado = 2 -> casilla ocupada
    
    //FUNCION A USAR PARA OBTENER LA CLAVE(MÓDULO O RESUIDO DE LA DIVISION)
    static int funcion(int dato, int tam){//PARA A PEDIR DATO Y TAMAÑO DE LA TABLA DE TIPO INT
        return(dato%tam);//NOS RETORNA EL RESULTADO DE LO QUE ESTA ENTRE () ES DECIR LO QUE SOBRA
    }
    //METODO PARA INSERTAR EL DATO A LA TABLA HASH
    //COMO PARAMETRO SE NECESITA ARREGLO DE TIPO DE LA MISMA CLASE, EL TAMAÑO DE LA TABLA Y EL DATO A INGRESAR
    static int insertar(Hash[] hash, int tam, int dato){
        boolean bandera = false;//INCIALIZACION DE LA BANDERA PARA USAR EN CICLO
        int clave = funcion(dato, tam);//LA CLAVE SE OBTIENE ATRAVES DE LA FUNCION ANTERIOR QUE SERA EL RESULTADO
        /*SE COMPRUEBA SI EL CASILLA ESTA OCUPADA DE SER ASI RETORNAMOS UN 1, PARA POSTERIORMENTE RESOLVER LA COLISION*/
        if(hash[clave].estado == 2){
            return 1;
        }else{//CASO CONTRARIO
            do{//INICIAMOS CICLO DO WHILE (PRIMERO ACTUA Y LUEGO PIENSA)
                /*SE COMPRUEBA SI ESTA VACIA O FUE OCUPADA*/
                if(hash[clave].estado == 0 || hash[clave].estado == 1){
                    //DE SER ASI EN ESA POSICION SE INGRESA EL DATO
                    hash[clave].dato = dato;
                    //Y SE LE INDICA QUE YA ESTA OCUPADA ESA CASILLA CON "2"
                    hash[clave].estado = 2;
                    //LA BANDERA SE IGUALA A TRUE PARA PODER ENTRAR AL CICLO
                    bandera = true;
                }//else{
                    //clave++;
                //}
             //MIENTRAS SE CUMPLA QUE LA BANDERA SE DIFERENTE DE SU VALOR ORIGINAL Y LA CLAVE
             //SEA MENOR AL AMAÑO DE LA TABLA SE EJECUTA LO DE ADENTRO "{}"
            }while(clave < tam && !bandera);
                //SI LA BANDERA ESTA EN EL ESTADO INSERCION (TRUE), SE INDICA QUE EL DATO SE INSERTO
                //EN LA POSICION DE LA CLAVE
                if(bandera){
                    JOptionPane.showMessageDialog(null, "EL ENTERO DIGITADO SE INSERTÓ EN LA POSICIÓN: " + clave);
                }else{//CASO CONTRARIO SIGNIFICA QUE LA TABLA ESTA LLENA
                    System.out.println("NO SE INSERTÓ EL ENTERO, TABLA LLENA!");
                }
            }//CASO DE QUE NO HALLA HABIDO ALGUN RESULTADO RETORNAMOS UN "-1"
            return -1;
    }
    //METODO PARA BUSCAR DATOS EN LA TABLA HASH
    static int buscar (Hash[] hash, int tam, int dato){//SE PIDEN LOS MISMOS PARAMETROS QUE EL METODO ANTERIOR
        int clave = funcion(dato, tam);//LA CLAVE SE OBTIENE ATRAVES DE LA FUNCION ANTERIOR QUE SERA EL RESULTADO
        //TODO ESTO SE REPITE MIENTRA LA CLAVE SE MENOR AL TAMAÑO LA TABLA
        while(clave < tam){
            //SI EL ARREGLO HASH EN LA POSICION CLAVE SU ESTADO ES IGUAL A 0
            //SIGNIFICA QUE EL ESPACIO O CASILLA ESTA VACIO Y RETORNAMOS UN -1
            if(hash[clave].estado == 0){
                return -1;
            //SI NO SI EL ARREGLO HASH EN LA POSICION CLAVE ES IGUAL AL DTAO PERO.....
            }else if(hash[clave].dato == dato){
                //SI EL ESTADO ESTA ELIMINADO SIGNIFICA QUE TAMPOCO ESTA EL DATO Y RETORNAMOS UN -1
                if(hash[clave].estado == 1){
                    return -1;
                }else{//SI NO SE CUMPLIO NADA DE LO ANTERIOR SIGNIFICA QUE AHI ESTA EL DATO
                    return clave;// Y RETORNAMOS LA CLAVE QUE ES EL INDICE EN EL QUE SE ENCUENTRA
                }
            }else{//CASO CONTARIO
                //LA CLAVE INCREMENTA PARA HACER TODO ESTE MISMO PROCESO EN LA CASILLA QUE SIGUE
                //HASTA QUE LA CLAVE SEA MENOR AL TAMAÑO DE LA TABLA
                clave++;
            }
        }
        return -1;
    }
    //METODO DE ELIMINAAR
    static int eliminar(Hash[] hash, int tam, int dato){//SE PIDEN LOS MISMOS PARAMETROS QUE EL METODO ANTERIOR
        //LA VARIABLE BISCA VA TOMAR EL VALOR DEL METODO BUSCAR ES DECIR UN VALOR DE LOS 
        //RETURNS QUE SE ENCUENTRAN AHI PARA POSTERIORMENTES HACER COMPARACIONES
        int busca = buscar(hash, tam, dato);
        //SE COMPRUEBA SI LA VARIBLE BUSCA ES IGUAL A -1
        //ES DECIR DE SI EXISTO UN DATO O NO PARA ELIMINAR
        if (busca == -1){
            return -1;//DECIR ASI LO INDICAMOS CON UN -1
        }else{//CASO CONTRARIO
            //LE DECIMOS QUE SU ESTADOVA A SER IGUAL A 1 
            //ES DECIR "CASILLA ELIMINADA"
            hash[busca].estado = 1;
            return busca;//Y RETORNAMOS LA POSICION
        }
    }
    //METODO PARA LA SOLUCION DE COLIONES CON EL METODO DE ENCADENAMIENTO ENLAZADO
    public void agregarAlaListaEnlazada(tope value) {//PARAMETROS EL VALOR Y TOPE
        //CREAMOS EL TEMPORAL DESDE LA CLASE NODO
        ClsNodo<tope> temporal = new ClsNodo<tope>(value);
        //SE COMPRUEBA SI LA CABECERA ESTA VACIA
        if (cabecera == null)
             //TEMPORAL TOMA EL VALOR DE LA CABECERA
            cabecera = temporal;
        else{//CASO CONTRARIO
            //EL VALOR SIGUIENTE VA A SER IGUAL A LA CABECERA
            ClsNodo<tope> siguiente = cabecera;
            //MIENTRAS EL SIGUIENTE DEL QUE LE SIGUE TENGA UN VALOR...
            while(siguiente.siguiente != null)
                //SIGUIENTE VA TOMAR EL VALOR DEL QUE LE SIGUE
                siguiente = siguiente.siguiente;
                //DESPUES SE VUELVE AL TEMPORAL
                siguiente.siguiente = temporal;
        }
        tamano++;//INCREMENTAMOS EL TAMAÑO DE LA LISTA	
    }
    //METODO PARA BUSCAR EN LA LISTA ENLAZADA
    public boolean buscarEnLE(int elemento){//SE PIDE COMO PARAMETRO EL ELEMENTO A BUSCAR
        ClsNodo temporal = inicio;//TEMPORAL DESDE NUESTRA CLSNODO AL INICIO DE TIPO NODO
        //MIENTRAS TEMPORAL TENGA UN DATO Y TEMPORAL ES DIR EL DATO SE DIFERENTE DEL ELEMENTO(EL DATO QUE QUEREMOS BSCAR)
        while(temporal != null && temporal.dato != elemento){
            //EL TEMPORAL VA A AVANZAR A LA SIGUIENTE CASILLA Y COMPROBARA LO MISMO DE ANTES 
            //HASTA QUE SE DESCUMPLA LA CONDICION
            temporal = temporal.siguiente;
        }//RETORNAMOS SI EXISTE O NO
        return temporal != null;
    }
    public void lETemp(){
        //MIENTRAS LA CABECERA TENGA UN DATO
        while(cabecera != null){
            //LA CABECERA VA SER IGUAL AL QUE LE SIGUE
            cabecera = cabecera.siguiente;
            tamano--;// Y SE DECREMENTA EL TAMAÑO
        }
    }
    //METODO PARA MOSTRAR EL RESULTADO DESPUES DE UNA COLISION GENERADA
    public void mostrarResultado(){
        //SE ASIGNA EL SIGUIENTE A LA CABECERA
        ClsNodo<tope> siguiente = cabecera;
        //MIENTRAS EL SIGUIENTE TENGA UNA VALOR SE EJECUTA LO DE ADENTRO....
        while(siguiente != null){
            //IMPRIMOS ESE VALOR QUE HALLA EN ESE ESPACIO Y CONCATENAMOS CON UNA ", "
            System.out.print(siguiente.valor+", ");
            //EL SIGUIENTE VA A SER IGUAL AL QUE LE SIGUE Y SE COMPRUEBA LO MISMO DE ANTES
            //ESTO HASTA QUE SE DESCUMPLA LA CONDICION. 
            siguiente = siguiente.siguiente;
        }
        System.out.print("\n");//UN SALTILLO DE LINEA XD
    } 
}