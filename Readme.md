# Base Relacional A
## Enunciado:

Tratase de conectar dende java a Postres para efectuar operacions de consulta e manipulacion de datos contra taboas (select,insert,update, delete)




PARTE 1

- dende o cliente psql lanzar o script produtos.sql como usuario postgres contra a base de datos postgres:

psql postgres
\i <ruta do ficheiro produtos.sql>



isto creara una taboa chamda productos ca seguinte estructura:

	CODIGO     VARCHAR2(3)  primary key
	DESCRICION  VARCHAR2(15)
	PREZO	integer
	DATAC Date

- Comprobar dende sqlplus que a taboa  foi creada correctamente :
  \d produtos




PARTE 2  APLICACION baserelacionalA


	- engadir o  driver de postgres  á libreria do proxecto (o tedes na ruta /home/postgres/programas/postgres....jar
	- engadir manualmento o paquete java.sql.*    , e dicir
	import java.sql.*

	- crear un metodo de nome 'conexion'  que devolva un obxecto tipo Connection chamado conn que se conecte a base de datos postgres mediante o usuario postgres , con password 'postgres' . O obxecto Connection crease así:  
            
    String driver = "jdbc:postgresql:";
    String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
    String porto = "5432";
    String sid = "postgres";
    String usuario = "postgres";
    String password = "postgres";
    String url = driver + host+ porto + "/" + sid;
    Connection conn = DriverManager.getConnection(url,usuario,password);
            


	-crear un metodo de nome 'insireProduto'  que permita inserir na taboa produtos unha fila pasandolle como parametros o codigo o nome e o prezo e a data de caducidade  dun produto

	- crear un metodo chamdo 'listaProdutos' que amose o contido dos rexistros que hai na base  (debe usarse crearse un resulSet e volcar o contido do mesmo ) 

- crear un metodo chamdo 'listaProdutoPorCodigo' que amose o contido do rexistro cuxo código de producto se pase por parametro

    - Crear un método de nome 'actualizaPre' tal que pasandolle o codigo e prezo dun rexistro actualize o campo  prezo do rexistro  que corresponde a dito  codigo.

    - Crear un método de nome 'eliminaProduto' tal que pasandolle o codigo  dun rexistro elimine o rexistro  que corresponde a dito  codigo.


COMPROBACION :
- inserir varios rexistros na taboa mediante o metodo insireProduto creado anteriormente usando sentencias sql standard   
os rexistros a  inserir son
p1 , parafusos, 3, 27/12/2020
p2 , cravos , 4, 6/4/2020
p3, tachas, 6, 3/7/2020

 	- Comprobar dende sqlplus que os rexistros foron creados e que podemos actualizar ou borrar algun deles usando os metodos creados anteriormente. e dicir :
	
		- ler os rexistros da taboa produtos do usuario hr mediante o metodo listaProdutos() creado anteriormente
		- modifica o rexistro de codigo p2 poñendo o seu prezo ao dobre do que ten actualmente
		-  borra o rexistro de codigo p3


nota: facer todas as comprobacions que precisedes para asegurarvos que funcionan todos as tarefas mencionadas


METODOS  necesarios para desenvolver esta aplicacion:

para inserir , borrar ou modificar datos debemos crea previamente un obxecto Statement mediante o metodo createStatement() do obxecto Connection. Despois  en funcion do que queramos facer escolleremos unha ou outro opcion de entre os seguintesmetodos do obxecto Statement creado anteriormente
- inserir : metodo executeUpdate("orde_de_insercion_sql")
- consultar (mediante resultset fordwar_only, read_only (por defecto)): crear un obxecto ResultSet a partir de aplicar o metodo executeQuery("consulta") a o obxecto Statement e recorrelo cun bucle . O xeito de recorrer un obxeto resultset (r) e finalizar o mesmo e invocar o seu metodo next() :  while (r.next()) {...
- borrar : metodo executeUpdate("orde_de_borrado_sql")
- modificar: metodo executeUpdate("orde_de_modificacion_sql")

NOTA importante :

para convertir unha data en formto String a Date  :
Date d = Date.valueOf(data);


para  pasar una data en formato cadea (String) a  java.sql.Date :
SimpleDateFormat format = new SimpleDateFormat("ddMMYYYY");
java.util.Date di;
di = format.parse("28022021");
java.sql.Date df = new java.sql.Date(di.getTime());
insireProduto("p5", "cepillos", 6.0, df);