

public class MatematicaRelacoes {


    public static void main(String[] args) {
    int x, loop=0, cont;   
    int cont3=0;
    char relacao[],ordem[];
 
    x = Input.readInt("Digite a quantidade de pares: ");        // Depois de informa a quantidade de pares
    x=x*2;                                                      // o valor é multiplicado por 2, para 
                                                                // criar um vetor. Cada posição do vetor,
    relacao = new char [x];                                      // zero e par para armazenar x, e os 
    ordem = new char [x];                                        // indices impares para armazenar y.
    
    //Armazenando os pares x e y                                   //
   for(cont=0;cont<x;cont++){                                      // Armazenamento dos pares.
       if(cont%2==0||cont==0){                                     // São armazenados em dois vetores.
        relacao[cont]=Input.readChar("Diga o valor de X: ");        // Mas o vetores recebem ambos os 
        ordem[cont]=relacao[cont];                                 // mesmos valores.
       }                                                           //
       else{                                                       //
        relacao[cont]=Input.readChar("Diga o valor de Y: ");        //
        ordem[cont]=relacao[cont];                                 //
       }
   }

   //Ordenação  por diferenciação                            
   int cont2;                                                       //
   int troca,cont4=0;                                               //
   boolean igual=false;                                             //
   ordem[cont3]=relacao[cont3];                                     //
     cont=0;                                                        //
        for( cont2 = cont + 1; cont2 < x; cont2++ ){                //
            if ( ordem[cont] != relacao[cont2] ){                   //
                for(cont4=cont3;cont4>=0;cont4--){                  //
                    if(relacao[cont2]==ordem[cont4]){               //
                        igual=true;                                 //
                    }                                               //
                }                                                   //
                if(igual==false){                                   //
                    cont3++;                                        //
                    ordem[cont3]=relacao[cont2];                    //
                }                                                   //
                igual=false;                                        //
            }                                                       //
       }                                                            //
    
   //verifica a quantidade de X diferentes foram inseridos      //
   int compara = ordem[0],quantidadex=1;                        // Verifica a quantidade de vértices
                                                                // existentes nesse vetor.
   for(cont=0;cont<=cont3;cont++){                                   // Com o vetor ja em ordem crescente
      if(ordem[cont]!=compara){                                 // aqui calcula a quantidade de números
      compara=ordem[cont];                                      // diferentes, me dando assim a quantidade
      quantidadex++;                                            // de vértices.
      }                                                         // Lembre-se o outro vetor não teve sua
    }                                                           // ordem modificada.
   System.out.println(" x quantidade: "+quantidadex);           //
   
   
   //Reflexiva
   int controle=0, impar=0 ,par=0;              // 
   boolean reflexiva=false;                     // se a posição for zero ou par
   for(cont=0;cont<x;cont=(cont+2)){            // atribui valores das posições do vetor na variavel
        if(cont%2==0||cont==0){                 // par e na variavel imp.
                par=cont;                       // se na posição par (x) for igual na posição impar (y)
                impar= cont+1;}                 // então o controle recebe mais 1 que ao finalizar
        if((relacao[par])==(relacao[impar])) {  // a verifiacação ele compara com a quantidade de
            controle++;                         // vértices.
        }                                       // 
        
   }
   
   if (controle==quantidadex){                          // compara se a quantidade de pares reflexivos
   System.out.println("A relação é Reflexiva. ");           // tem a mesma quantidade dos vértices exitentes
   reflexiva = true;}                                   //
   else {                                               //
       System.out.println("A relação não é Reflexiva");}    //
 
   //Simétrica
   boolean simetrica =false;
   char pares[];
   int  aux;
   pares = new char [2];
 
   int relat=0;
   for(cont=0;cont<x;cont=(cont+2)){
       pares[0]= relacao[cont];
       aux=cont+1;
       pares[1]= relacao[aux];
           for( cont2=0;cont2<x;cont2=(cont2+2)) {
               if((pares[0]==relacao[(cont2+1)])&&(pares[1]==relacao[(cont2)])){
                   relat++;
                }
            }
   
   }
   if ((relat-controle)==quantidadex){
       System.out.println("A relação é Simétrica");
       simetrica=true;
   }
   else{
       System.out.println("A relação não é Simetrica");
   }  
 
    //Assimétrica
   
   if((controle==0)&&(relat==0)){
        System.out.println("A relação é Assimétrica");
    }
   else{
       System.out.println("A relação não é Assimétrica");
   }

   
    //Transitiva
   
   char pares1[];
   boolean transitiva=false;
   pares1= new char [2];
   
   
   for(cont=0;cont<x;cont=(cont+2)){
       aux=cont+1;
       pares[0]=relacao[cont];
       pares[1]=relacao[aux];
       
            for( cont2=0;cont2<x;cont2=(cont2+2)){
                aux=cont2+1;
               
                if((relacao[cont2]==pares[0])&&(relacao[aux]!= pares[1])){
                 pares1[0] = relacao[cont2];
                 pares1[1] = relacao[aux];
                 
                    for(cont3=0;cont3<x;cont3=(cont3+2)){
                        aux=cont3+1;
                        if((relacao[cont3]==pares[1]) && (relacao[aux]==pares1[1])){
                        transitiva=true;
                        
                        }
                        if((relacao[aux]==pares[1])&& (relacao[cont3]==pares1[1])){
                        transitiva=true;
                        
                        }
                  
                    }
                }
            }
   }
   if(transitiva==true){
       System.out.println("A Relação é Transitiva");
   }
   else{
       System.out.println("A Relação não é Transitiva");
   }
  
   
   //Antissemetrica
   boolean antissimetrica=false;
      if ((controle>2) && (relat==0)){
   for(cont=0;cont<x;cont=cont+2){
       aux=cont+1;
       if(relacao[cont]==relacao[aux]){
           pares[0]=relacao[cont];
           System.out.println("A["+pares[0]+"]["+pares[0]+"]");
               for(cont2=cont+2;cont2<x;cont2=cont2+2){
                    aux=cont2+1;
                    if(relacao[cont2]==relacao[aux]){
                        pares[1]=relacao[cont2];
                        System.out.println("A["+pares[1]+"]["+pares[1]+"]");
                           
                        for(cont3=0;cont3<x;cont3=cont3+2){
                                aux=cont3+1;
                             
                                    if((relacao[cont3]==pares[0])&& (relacao[aux]==pares[1])){
                                        antissimetrica=true;
                                    }
                                    if((relacao[cont3]==pares[1])&&(relacao[aux]==pares[0])){
                                        antissimetrica=true;
                                    }
                                    
                            }
                        
                        
                    }
                    
                }
       }
   
   }
        if(antissimetrica==true){
             System.out.println("A Relação é Antissimétrica");
         }
      }  
    
    else{
          System.out.println("A Relação não é Antissimétrica");
    }
      
    
   //Equivalente
   if(reflexiva==true && simetrica==true && transitiva==true){
       System.out.println("A Relação é Equivalente");
   }
   else{
       System.out.println("A Relação não é Equivalente");
   }
             
    }//fim main void
}//fim public class
