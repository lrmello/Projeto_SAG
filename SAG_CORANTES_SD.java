import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class SAG_CORANTES_SD
{
	public static void main(String args[]) throws FileNotFoundException
	{
	
	Scanner entrada = new Scanner( System.in );

	PrintWriter out = new PrintWriter("SAG_EstatisticaCORANTES_SD.txt");


	out.println( "GERACAO" + " " + "INDIVIDUO" + " " +  "VAR_U" + " " + "VAR_V" + " " + "VAR_W" + " " + "VAR_X" + " " + "VAR_Y" + " " + "VAR_Z" + " " + "AVALIACAO" );

	//Declara variaveis para o Valor Otimo
	double Valor_Otimo_u = 0;
	double Valor_Otimo_v = 0;
	double Valor_Otimo_w = 0;
	double Valor_Otimo_x = 0;
	double Valor_Otimo_y = 0;
	double Valor_Otimo_z = 0;
	double Valor_Otimo_avaliacao = 0;
	double Valor_Otimo_geracao = 0;

	//Declara variavel para o numero da POPULACAO INICIAL
	int pop_inicial = 0;

	//Auxiliar para verificação se o número digitado é PAR
	long aux_long = 1;

	//captura VARIAVEL (individuos)
	while ( ( aux_long != 0 )  | ( pop_inicial <= 0 ) )
	{
		System.out.print("POPULACAO INICIAL <Num.Par e Maior que 0>: ");
		pop_inicial = entrada.nextInt();
		aux_long = pop_inicial % 2;
	}

	System.out.printf("\nConfirmacao,POPULACAO INICIAL =  %d\n", pop_inicial );

	//Declara variavel para o numero de ITERACOES
	long max_interacoes = 0;

	//Declara variavel para o numero de ITERACOES
	double temp = 0;

	//captura VARIAVEL (iteracoes)
	while ( max_interacoes < 1 )
	{
		System.out.print("\nQtde.ITERACOES(CICLOS) do SA para cada individuo da Pop.Inicial: ");
		max_interacoes = entrada.nextLong();
	}

	System.out.printf("\nConfirmacao, ITERACOES(CICLOS) do SA para cada individuo da Pop.Inicial =   %d\n", Math.round( max_interacoes ) );

	//Declara variavel para o numero de INDIVIDUOS
	int individuos = 0;

	//Auxiliar para verificação se o número digitado é PAR
	aux_long = 1;

	//captura VARIAVEL (individuos)
	while ( ( aux_long != 0 )  | ( individuos > pop_inicial ) | ( individuos <= 0 ))
	{
		System.out.print("\nPOPULACAO para demais Geracoes <Num.Par e Maior que 0>: ");
		individuos = entrada.nextInt();
		aux_long = individuos % 2;
	}

	System.out.printf("\nConfirmacao,POPULACAO por Geracao =   %d\n", individuos );

	//Declara variavel para o percentual de elitismo
	double perc_elite = -1;

	//captura VARIAVEL (Elitismo)
	while ( perc_elite < 0 | perc_elite > 100 )
	{
		System.out.print("\nPercentual de ELITISMO(0 a 100): ");
		perc_elite = entrada.nextDouble();
	}

	System.out.printf("\nConfirmacao, Percentual de ELITISMO =   %.4f\n", perc_elite );

// Calcula o numero de individuos que farao parte da Elite
	int elite = Math.round( Math.round( individuos * ( perc_elite /100 ) ) );
	System.out.printf("\nConfirmacao, Individuos na ELITE =   %d\n", elite );

	//Declara variavel para o numero de ITERACOES
	long interacoes = 0;

	//captura VARIAVEL (iteracoes)
	while ( interacoes < 1 )
	{
		System.out.print("\nQtde.GERACOES do AG: ");
		interacoes = entrada.nextLong();
	}

	System.out.printf("\nConfirmacao, GERACOES do AG=   %d\n", Math.round( interacoes ) );

	//Declara variavel para Taxa de Mutacao
	int tx_mutacao = -1;

	//captura VARIAVEL (Taxa de Mutacao)
	while ( ( tx_mutacao < 0 )  | ( tx_mutacao > 100 ) )
	{
		System.out.print("\nTx.MUTACAO ( Entre 0 e 100 ): ");
		tx_mutacao = entrada.nextInt();
	}

	System.out.printf("\nConfirmacao,Tx.MUTACAO =   %d\n", tx_mutacao );

	// (u) - representa a variável - matriz 1
	int u[] = new int[ pop_inicial + 1 ];

	// (v) - representa a variável - matriz 1
	int v[] = new int[ pop_inicial + 1 ];

	// (w) - representa a variável - matriz 1
	int w[] = new int[ pop_inicial + 1 ];

	// (x) - representa a variável - matriz 1
	int x[] = new int[ pop_inicial + 1 ];

	// (y) - representa a variável - matriz 1
	int y[] = new int[ pop_inicial + 1 ];

	// (z) - representa a variável - matriz 1
	int z[] = new int[ pop_inicial + 1 ];

	//VETORES 2
	// (u) - representa a variável - matriz 2
	int u2[] = new int[ pop_inicial + 1 ];

	// (v) - representa a variável - matriz 2
	int v2[] = new int[ pop_inicial + 1 ];

	// (w) - representa a variável - matriz 2
	int w2[] = new int[ pop_inicial + 1 ];

	// (x) - representa a variável - matriz 2
	int x2[] = new int[ pop_inicial + 1 ];

	// (y) - representa a variável - matriz 2
	int y2[] = new int[ pop_inicial + 1 ];

	// (z) - representa a variável - matriz 1
	int z2[] = new int[ pop_inicial + 1 ];

	// binario de (u)
	String bin_u[] = new String[ pop_inicial + 1 ];

	// binario de (v)
	String bin_v[] = new String[ pop_inicial + 1 ];

	// binario de (w)
	String bin_w[] = new String[ pop_inicial + 1 ];

	// binario de (x)
	String bin_x[] = new String[ pop_inicial + 1 ];

	// binario de (y)
	String bin_y[] = new String[ pop_inicial + 1 ];

	// binario de (z)
	String bin_z[] = new String[ pop_inicial + 1 ];

	// resultado da equacao de avaliacao - matriz 1
	double avaliacao[] = new double[ pop_inicial + 1 ];

	// resultado da equacao de avaliacao - matriz 2
	double avaliacao2[] = new double[ pop_inicial + 1 ];

	// limite inferior do intervalo da avaliação usado no sorteio da roleta viciada - matriz 1
	double intervalo_de[] = new double[ pop_inicial + 1 ];

	// limite superior do intervalo da avaliação usado no sorteio da roleta viciada - matriz 1
	double intervalo_ate[] = new double[ pop_inicial + 1 ];

	// limite inferior do intervalo da avaliação usado no sorteio da roleta viciada - matriz 2
	double intervalo_de2[] = new double[ pop_inicial + 1 ];

	// limite superior do intervalo da avaliação usado no sorteio da roleta viciada - matriz 2
	double intervalo_ate2[] = new double[ pop_inicial + 1 ];

	//Declara limitadores das variaveis do problema e Precisao de Pontos Decimais para o # AG #
	int u_inf = 0;
	int u_sup = 0;
	int u_dec = -1;

	int v_inf = 0;
	int v_sup = 0;
	int v_dec = -1;

	int w_inf = 0;
	int w_sup = 0;
	int w_dec = -1;

	int x_inf = 0;
	int x_sup = 0;
	int x_dec = -1;

	int y_inf = 0;
	int y_sup = 0;
	int y_dec = -1;

	int z_inf = 0;
	int z_sup = 0;
	int z_dec = -1;
	
	int sim1_nao0 = 1;
	//Declara limitadores das variaveis do problema e Precisao de Pontos Decimais para o # SA #
	double u_infd = -1;
	double u_supd = -1;
	
	double v_infd = -1;
	double v_supd = -1;
	
	double w_infd = -1;
	double w_supd = -1;
	
	double x_infd = -1;
	double x_supd = -1;
	
	double y_infd = -1;
	double y_supd = -1;

	double z_infd = -1;
	double z_supd = -1;

	u_dec = 1;

	u_infd = 22;
		
	u_inf = Math.round( Math.round( u_infd * Math.pow( 10, u_dec ) ) );

	u_supd = 78;

	u_sup = Math.round( Math.round( u_supd * Math.pow( 10, u_dec ) ) );

	System.out.println("\nu_inf.: " + u_inf + " | u_sup.: " + u_sup + " | ( * ) u_dec.: " + u_dec);

	v_dec = 1;

	v_infd = 20;

	v_inf = Math.round( Math.round( v_infd * Math.pow( 10, v_dec ) ) );

	v_supd = 97;

	v_sup = Math.round( Math.round( v_supd * Math.pow( 10, v_dec ) ) );

	System.out.println("\nv_inf.: " + v_inf + " | v_sup.: " + v_sup + " | ( * ) v_dec.: " + v_dec);

	w_dec = 1;

	w_infd = 0.425;

	w_inf = Math.round( Math.round( w_infd * Math.pow( 10, w_dec ) ) );

	w_supd = 14.575;

	w_sup = Math.round( Math.round( w_supd * Math.pow( 10, w_dec ) ) );

	System.out.println("\nw_inf.: " + w_inf + " | w_sup.: " + w_sup + " | ( * ) w_dec.: " + w_dec);

	x_dec = 1;

	x_infd = 0.5;

	x_inf = Math.round( Math.round( x_infd * Math.pow( 10, x_dec ) ) );

	x_supd = 4.3;

	x_sup = Math.round( Math.round( x_supd * Math.pow( 10, x_dec ) ) );

	System.out.println("\nx_inf.: " + x_inf + " | x_sup.: " + x_sup + " | ( * ) x_dec.: " + x_dec);

	y_dec = 1;

	y_infd = 30;

	y_inf = Math.round( Math.round( y_infd * Math.pow( 10, y_dec ) ) );

	y_supd = 145;

	y_sup = Math.round( Math.round( y_supd * Math.pow( 10, y_dec ) ) );

	System.out.println("\ny_inf.: " + y_inf + " | y_sup.: " + y_sup + " | ( * ) y_dec.: " + y_dec);

	z_dec = 1;

	z_infd = 1;

	z_inf = Math.round( Math.round( z_infd * Math.pow( 10, z_dec ) ) );

	z_supd = 4.8;

	z_sup = Math.round( Math.round( z_supd * Math.pow( 10, z_dec ) ) );

	System.out.println("\nz_inf.: " + z_inf + " | z_sup.: " + z_sup + " | ( * ) z_dec.: " + z_dec);

	int maior_dec = u_dec;
	if ( v_dec > maior_dec)
		maior_dec = v_dec;
	if ( w_dec > maior_dec)
		maior_dec = w_dec;
	if ( x_dec > maior_dec)
		maior_dec = x_dec;
	if ( y_dec > maior_dec)
		maior_dec = y_dec;
	if ( z_dec > maior_dec)
		maior_dec = z_dec;

	int dif_u_dec = maior_dec - u_dec;
	int dif_v_dec = maior_dec - v_dec;
	int dif_w_dec = maior_dec - w_dec;
	int dif_x_dec = maior_dec - x_dec;
	int dif_y_dec = maior_dec - y_dec;
	int dif_z_dec = maior_dec - z_dec;

	u_inf = u_inf * Math.round( Math.round( Math.pow( 10, dif_u_dec ) ) );
	u_sup = u_sup * Math.round( Math.round( Math.pow( 10, dif_u_dec ) ) );
	System.out.println("u_inf .: " + u_inf + " | u_sup .: " + u_sup);

	v_inf = v_inf * Math.round( Math.round( Math.pow( 10, dif_v_dec ) ) );
	v_sup = v_sup * Math.round( Math.round( Math.pow( 10, dif_v_dec ) ) );
	System.out.println("v_inf .: " + v_inf + " | v_sup .: " + v_sup);

	w_inf = w_inf * Math.round( Math.round( Math.pow( 10, dif_w_dec ) ) );
	w_sup = w_sup * Math.round( Math.round( Math.pow( 10, dif_w_dec ) ) );
	System.out.println("w_inf .: " + w_inf + " | w_sup .: " + w_sup);

	x_inf = x_inf * Math.round( Math.round( Math.pow( 10, dif_x_dec ) ) );
	x_sup = x_sup * Math.round( Math.round( Math.pow( 10, dif_x_dec ) ) );
	System.out.println("x_inf .: " + x_inf + " | x_sup .: " + x_sup);

	y_inf = y_inf * Math.round( Math.round( Math.pow( 10, dif_y_dec ) ) );
	y_sup = y_sup * Math.round( Math.round( Math.pow( 10, dif_y_dec ) ) );
	System.out.println("y_inf .: " + y_inf + " | y_sup .: " + y_sup);

	z_inf = z_inf * Math.round( Math.round( Math.pow( 10, dif_z_dec ) ) );
	z_sup = z_sup * Math.round( Math.round( Math.pow( 10, dif_z_dec ) ) );
	System.out.println("z_inf .: " + z_inf + " | z_sup .: " + z_sup);
	//Declara variavel para Qtde Bits de (u)
	int qbits_u;
	//Declara variavel para Qtde Bits de (v)
	int qbits_v;
	//Declara variavel para Qtde Bits de (w)
	int qbits_w;
	//Declara variavel para Qtde Bits de (x)
	int qbits_x;
	//Declara variavel para Qtde Bits de (y)
	int qbits_y;
	//Declara variavel para Qtde Bits de (z)
	int qbits_z;

	int i;
  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( u_sup ); i++ );
	qbits_u = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( u )\n  %d = %.4f\n", qbits_u, Math.pow( 2, qbits_u ) );
	int centro_gene_u = qbits_u / 2;
	int ini_qbits_u = 0;
	int fim_qbits_u = qbits_u;

  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( v_sup ); i++ );
	qbits_v = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( v )\n  %d = %.4f\n", qbits_v, Math.pow( 2, qbits_v ) );
	int centro_gene_v = qbits_v / 2;
	int ini_qbits_v = qbits_u;
	int fim_qbits_v = qbits_u + qbits_v;

  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( w_sup ); i++ );
	qbits_w = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( w )\n  %d = %.4f\n", qbits_w, Math.pow( 2, qbits_w ) );
	int centro_gene_w = qbits_w / 2;
	int ini_qbits_w = qbits_u + qbits_v;
	int fim_qbits_w = qbits_u + qbits_v + qbits_w;

  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( x_sup ); i++ );
	qbits_x = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( x )\n  %d = %.4f\n", qbits_x, Math.pow( 2, qbits_x ) );
	int centro_gene_x = qbits_x / 2;
	int ini_qbits_x = qbits_u + qbits_v + qbits_w;
	int fim_qbits_x = qbits_u + qbits_v + qbits_w + qbits_x;

  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( y_sup ); i++ );
	qbits_y = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( y )\n  %d = %.4f\n", qbits_y, Math.pow( 2, qbits_y ) );
	int centro_gene_y = qbits_y / 2;
	int ini_qbits_y = qbits_u + qbits_v + qbits_w + qbits_x;
	int fim_qbits_y = qbits_u + qbits_v + qbits_w + qbits_x + qbits_y;

  	for ( i = 1; Math.pow( 2, i ) <= Math.abs( z_sup ); i++ );
	qbits_z = i;
	System.out.printf("\nQtde.Bits - Multiplo - ( z )\n  %d = %.4f\n", qbits_z, Math.pow( 2, qbits_z ) );
	int centro_gene_z = qbits_z / 2;
	int ini_qbits_z = qbits_u + qbits_v + qbits_w + qbits_x + qbits_y;
	int fim_qbits_z = qbits_u + qbits_v + qbits_w + qbits_x + qbits_y + qbits_z;

	double val_min;

	System.out.printf("\nVl.Min.para Resultado Corantes .: ");
	val_min = entrada.nextDouble();

	System.out.printf("\nConfirmacao, Vl.Min.para RESULTADO CORANTES =   %.2f\n \n", val_min );

	Random aleatorio = new Random(); // gerador de número aleatório

	double tot_avaliacoes = 0;

	double tot_avaliacoes2 = 0;

	int seq_ger = 0;

  	int counter = 0;

	double u_aux = 0;
	double u_aux_n = 0;

	double v_aux = 0;
	double v_aux_n = 0;

	double w_aux = 0;
	double w_aux_n = 0;

	double x_aux = 0;
	double x_aux_n = 0;

	double y_aux = 0;
	double y_aux_n = 0;

	double z_aux = 0;
	double z_aux_n = 0;
	
	int var_maior_dec = Math.round(Math.round(Math.pow( 10, maior_dec )));
	
	
  	for (counter = 1; counter <= pop_inicial; counter++)
  	{
		double dcounter = counter;

		System.out.printf("\n# # # #    SIMULATED ANNEALING   # # # # - INDIVIDUO %03d\n", counter );
	
		double ud = 0;
		double vd = 0;
		double wd = 0;
		double xd = 0;
		double yd = 0;
		double zd = 0;
	
		// resultado da equacao de avaliacao
		double avaliacao_inicial = 0;
		double avaliacao_corrente = 0;
		double avaliacao_sucessor = 0;
		double avaliacao_melhor = 0;

		if ( u_supd == u_infd )
			ud = u_infd; 
		else
			ud = u_infd + ( Math.random() * ( u_supd - u_infd ) ); 
	
		if ( v_supd == v_infd )
			vd = v_infd; 
		else
			vd = v_infd + ( Math.random() * ( v_supd - v_infd ) ); 
	
		if ( w_supd == w_infd )
			wd = w_infd; 
		else
			wd = w_infd + ( Math.random() * ( w_supd - w_infd ) ); 
	
		if ( x_supd == x_infd )
			xd = x_infd; 
		else
			xd = x_infd + ( Math.random() * ( x_supd - x_infd ) ); 
	
		if ( y_supd == y_infd )
		 	yd = y_infd;
		else
		 	yd = y_infd + ( Math.random() * ( y_supd - y_infd ) ); 
	
		if ( z_supd == z_infd )
		 	zd = z_infd;
		else
		 	zd = z_infd + ( Math.random() * ( z_supd - z_infd ) ); 

		// ************************************
		// Normaliza os valores
		// ************************************
		// Replica(0) = 15
		// Fator(1) = 20
		u_aux_n = ( ( ud - 50 ) / ( 50 - 40 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		v_aux_n = ( ( vd - 40 ) / ( 40 - 20 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		w_aux_n = ( ( wd - 7.5 ) / ( 7.5 - 5.0 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		x_aux_n = ( ( xd - 1.5 ) / ( 1.5 - 0.5 ) );
		// Replica(0) = 45
		// Fator(1) = 55
		y_aux_n = ( ( yd - 60 ) / ( 60 - 30 ) );
		// Replica(0) = 60
		// Fator(1) = 90
		z_aux_n = ( ( zd - 2 ) / ( 2 - 1 ) );
	
	 	// EQUACAO DE AVALIACAO (OBJETIVO) - POPULACAO INICIAL
		avaliacao_inicial = Math.abs( 21.2098+1.1576*u_aux_n+1.9929*v_aux_n+0.5279*w_aux_n-1.3504*x_aux_n+1.9462*y_aux_n+6.0507*z_aux_n-0.5191*( Math.pow( u_aux_n, 2 ) )-0.8979*( Math.pow( v_aux_n, 2 ) )-0.2979*( Math.pow( w_aux_n, 2 ) )-0.6904*( Math.pow( x_aux_n, 2 ) )-1.2596*( Math.pow( y_aux_n, 2 ) )-1.2264*( Math.pow( z_aux_n, 2 ) )+0.5792*(u_aux_n*v_aux_n)-0.1998*(u_aux_n*w_aux_n)-0.7289*(u_aux_n*x_aux_n)-2.6617*(u_aux_n*y_aux_n)+0.8850*(u_aux_n*z_aux_n)+0.1362*(v_aux_n*w_aux_n)+0.1345*(v_aux_n*x_aux_n)+0.6864*(v_aux_n*z_aux_n)-0.3035*(w_aux_n*y_aux_n)+0.1613*(w_aux_n*z_aux_n)-0.4896*(x_aux_n*y_aux_n)-0.3572*(x_aux_n*z_aux_n)+0.7686*(y_aux_n*z_aux_n) +0.1211*(u_aux_n*v_aux_n*x_aux_n)-0.3977*(u_aux_n*v_aux_n*y_aux_n)+0.2121*(u_aux_n*v_aux_n*z_aux_n)+0.1933*(u_aux_n*w_aux_n*x_aux_n)+0.4352*(u_aux_n*w_aux_n*y_aux_n)-0.2686*(u_aux_n*w_aux_n*z_aux_n)+0.2004*(u_aux_n*x_aux_n*y_aux_n)-0.3588*(u_aux_n*x_aux_n*z_aux_n)-0.8692*(u_aux_n*y_aux_n*z_aux_n)+0.1811*(v_aux_n*w_aux_n*z_aux_n)+0.1237*(v_aux_n*x_aux_n*y_aux_n)+0.1133*(v_aux_n*y_aux_n*z_aux_n)-0.1898*(w_aux_n*x_aux_n*y_aux_n)-0.3587*(x_aux_n*y_aux_n*z_aux_n)-0.1275*(u_aux_n*v_aux_n*y_aux_n*z_aux_n)-0.3140*(u_aux_n*w_aux_n*x_aux_n*y_aux_n)+0.2638*(u_aux_n*w_aux_n*y_aux_n*z_aux_n)+0.1634*(v_aux_n*w_aux_n*x_aux_n*y_aux_n)-0.1138*(v_aux_n*w_aux_n*x_aux_n*z_aux_n)+0.1381*(u_aux_n*v_aux_n*x_aux_n*y_aux_n*z_aux_n)-0.1027*(u_aux_n*v_aux_n*w_aux_n*y_aux_n*z_aux_n) );
		// Salva Valor Otimo
		Valor_Otimo_u = ud;
		Valor_Otimo_v = vd;
		Valor_Otimo_w = wd;
		Valor_Otimo_x = xd;
		Valor_Otimo_y = yd;
		Valor_Otimo_z = zd;
		avaliacao_melhor = avaliacao_inicial;

	if ( avaliacao_inicial >= val_min) 
	{
		System.out.printf( "# # # # #   V A L O R    M I N I M O    A T I N G I D O   # # # # #\n" ); 
		System.out.printf( "\n (ud) | (vd) | (wd) | (xd) | (yd) | (zd) - AVALIACAO\n" ); 
     	System.out.printf( " %.4f | %.4f | %.4f | %.4f | %.4f | %.4f  =  %.4f\n", ud, vd, wd, xd, yd, zd, avaliacao_inicial ); 

		System.out.print("Deseja continuar? (Sim=1/Nao=0) - # 01 #");
		sim1_nao0 = entrada.nextInt();
	}
	else
	{


	}

	if ( sim1_nao0 == 1 )
	{	// if ( sim1_nao0 ) == 0 - # 01 # - INICIO
	
		avaliacao_corrente = avaliacao_inicial;

		double cont_inter = 1;
	

		while ( ( cont_inter <= max_interacoes ) && ( sim1_nao0 == 1 ) ) // condição de continuação do loop
		{  // inicio loop - L O O P I N G   D E   I T E R A C O E S
			temp = max_interacoes - cont_inter;
			
			if ( temp > 0 )
			{

				//(u)
				if ( u_supd == u_infd )
					ud = u_infd; 
				else
					ud = u_infd + ( Math.random() * ( u_supd - u_infd ) ); 
		
				//(v)
				if ( v_supd == v_infd )
					vd = v_infd; 
				else
					vd = v_infd + ( Math.random() * ( v_supd - v_infd ) ); 
		
				//(w)
				if ( w_supd == w_infd )
					wd = w_infd; 
				else
					wd = w_infd + ( Math.random() * ( w_supd - w_infd ) ); 
		
				//(x)
				if ( x_supd == x_infd )
					xd = x_infd; 
				else
					xd = x_infd + ( Math.random() * ( x_supd - x_infd ) ); 
		
				//(y)
				if ( y_supd == y_infd )
				 	yd = y_infd;
				else
				 	yd = y_infd + ( Math.random() * ( y_supd - y_infd ) ); 
			
				//(z)
				if ( z_supd == z_infd )
				 	zd = z_infd;
				else
				 	zd = z_infd + ( Math.random() * ( z_supd - z_infd ) ); 
			
		// ************************************
		// Normaliza os valores
		// ************************************
		// Replica(0) = 15
		// Fator(1) = 20
		u_aux_n = ( ( ud - 50 ) / ( 50 - 40 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		v_aux_n = ( ( vd - 40 ) / ( 40 - 20 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		w_aux_n = ( ( wd - 7.5 ) / ( 7.5 - 5.0 ) );
		// Replica(0) = 15
		// Fator(1) = 20
		x_aux_n = ( ( xd - 1.5 ) / ( 1.5 - 0.5 ) );
		// Replica(0) = 45
		// Fator(1) = 55
		y_aux_n = ( ( yd - 60 ) / ( 60 - 30 ) );
		// Replica(0) = 60
		// Fator(1) = 90
		z_aux_n = ( ( zd - 2 ) / ( 2 - 1 ) );
	
	 	// EQUACAO DE AVALIACAO (OBJETIVO) - POPULACAO INICIAL
		avaliacao_sucessor = Math.abs( 21.2098+1.1576*u_aux_n+1.9929*v_aux_n+0.5279*w_aux_n-1.3504*x_aux_n+1.9462*y_aux_n+6.0507*z_aux_n-0.5191*( Math.pow( u_aux_n, 2 ) )-0.8979*( Math.pow( v_aux_n, 2 ) )-0.2979*( Math.pow( w_aux_n, 2 ) )-0.6904*( Math.pow( x_aux_n, 2 ) )-1.2596*( Math.pow( y_aux_n, 2 ) )-1.2264*( Math.pow( z_aux_n, 2 ) )+0.5792*(u_aux_n*v_aux_n)-0.1998*(u_aux_n*w_aux_n)-0.7289*(u_aux_n*x_aux_n)-2.6617*(u_aux_n*y_aux_n)+0.8850*(u_aux_n*z_aux_n)+0.1362*(v_aux_n*w_aux_n)+0.1345*(v_aux_n*x_aux_n)+0.6864*(v_aux_n*z_aux_n)-0.3035*(w_aux_n*y_aux_n)+0.1613*(w_aux_n*z_aux_n)-0.4896*(x_aux_n*y_aux_n)-0.3572*(x_aux_n*z_aux_n)+0.7686*(y_aux_n*z_aux_n) +0.1211*(u_aux_n*v_aux_n*x_aux_n)-0.3977*(u_aux_n*v_aux_n*y_aux_n)+0.2121*(u_aux_n*v_aux_n*z_aux_n)+0.1933*(u_aux_n*w_aux_n*x_aux_n)+0.4352*(u_aux_n*w_aux_n*y_aux_n)-0.2686*(u_aux_n*w_aux_n*z_aux_n)+0.2004*(u_aux_n*x_aux_n*y_aux_n)-0.3588*(u_aux_n*x_aux_n*z_aux_n)-0.8692*(u_aux_n*y_aux_n*z_aux_n)+0.1811*(v_aux_n*w_aux_n*z_aux_n)+0.1237*(v_aux_n*x_aux_n*y_aux_n)+0.1133*(v_aux_n*y_aux_n*z_aux_n)-0.1898*(w_aux_n*x_aux_n*y_aux_n)-0.3587*(x_aux_n*y_aux_n*z_aux_n)-0.1275*(u_aux_n*v_aux_n*y_aux_n*z_aux_n)-0.3140*(u_aux_n*w_aux_n*x_aux_n*y_aux_n)+0.2638*(u_aux_n*w_aux_n*y_aux_n*z_aux_n)+0.1634*(v_aux_n*w_aux_n*x_aux_n*y_aux_n)-0.1138*(v_aux_n*w_aux_n*x_aux_n*z_aux_n)+0.1381*(u_aux_n*v_aux_n*x_aux_n*y_aux_n*z_aux_n)-0.1027*(u_aux_n*v_aux_n*w_aux_n*y_aux_n*z_aux_n) );

				if ( avaliacao_sucessor > avaliacao_melhor )
				{

					// Salva Valor Otimo
					Valor_Otimo_u = ud;
					Valor_Otimo_v = vd;
					Valor_Otimo_w = wd;
					Valor_Otimo_x = xd;
					Valor_Otimo_y = yd;
					Valor_Otimo_z = zd;
				 	avaliacao_melhor = avaliacao_sucessor;

				 	avaliacao_corrente = avaliacao_sucessor;
				}
				else
				{
				double delta = 	avaliacao_sucessor - avaliacao_corrente;

				if ( delta > 0 )
				{
				 	avaliacao_corrente = avaliacao_sucessor;
				}
				else
				{
					double prob_aleatorio = Math.random() * 1;
				 	double probabilidade = Math.exp(delta / temp); 

				 	if ( probabilidade > prob_aleatorio )
					 	avaliacao_corrente = avaliacao_sucessor;
				}

				}

				//Verifica de individuo atingiu o VALOR MINIMO
				if ( avaliacao_corrente >= val_min) 
				{
					System.out.printf( "# # # # #   V A L O R    M I N I M O    A T I N G I D O   # # # # #\n" ); 
			      	// Exibe o cabecalho da relacao de individuos da populacao inicial
					System.out.printf( "\n (ud) | (vd) | (wd) | (xd) | (yd) | (zd) - AVALIACAO\n" ); 
					// exibe os valores gerados
			     	System.out.printf( " %.4f | %.4f | %.4f | %.4f | %.4f | %.4f  =  %.4f\n", ud, vd, wd, xd, yd, zd, avaliacao_corrente ); 
			
					// Verifica se o usuario de continuar com o processamento
					System.out.print("Deseja continuar? (Sim=1/Nao=0) - # 01 #");
					sim1_nao0 = entrada.nextInt();
				}
				else
				{
			
				}

			}
			
			++cont_inter;

		}  // fim loop - L O O P I N G   D E   I T E R A C O E S

	}		// if ( sim1_nao0 == 1)  // # 01 #

		u[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_u)); 
		v[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_v)); 
		w[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_w)); 
		x[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_x)); 
	 	y[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_y)); 
	 	z[ counter ] = var_maior_dec * Math.round( Math.round(Valor_Otimo_z)); 

		avaliacao[ counter ] = avaliacao_melhor;
		
		tot_avaliacoes += ( avaliacao_melhor + 1 );

		intervalo_de[ counter ] = intervalo_ate[ counter - 1 ] + 1;

		intervalo_ate[ counter ] = intervalo_de[ counter ] + avaliacao_melhor;

		out.printf("0 %d %.4f %.4f %.4f %.4f %.4f %.4f %.4f Populacao_Inicial_SA\n",counter,Valor_Otimo_u,Valor_Otimo_v,Valor_Otimo_w,Valor_Otimo_x,Valor_Otimo_y,Valor_Otimo_z,avaliacao_melhor);
   } // for final - (individuos) - populacao inicial

	//POSICAO DE CORTE  do GENE da variavel ( u )  no cromossomo no Cross Over
	int pos_corte_u;

	//POSICAO DE CORTE  do GENE da variavel ( v )  no cromossomo no Cross Over
	int pos_corte_v;

	//POSICAO DE CORTE  do GENE da variavel ( w )  no cromossomo no Cross Over
	int pos_corte_w;

	//POSICAO DE CORTE  do GENE da variavel ( x )  no cromossomo no Cross Over
	int pos_corte_x;

	//POSICAO DE CORTE  do GENE da variavel ( y )  no cromossomo no Cross Over
	int pos_corte_y;

	//POSICAO DE CORTE  do GENE da variavel ( z )  no cromossomo no Cross Over
	int pos_corte_z;

		// Verifica se o usuario deseja continuar apos ultrapassar o valor minimo
		if ( sim1_nao0 == 1)  // # 02 #
		{

	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
	System.out.printf( "\nPor favor, aguarde!  Em processo de Elitismo...\n");
	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");

      	for ( int e = 1; e <= ( pop_inicial - 1 ); e++ )
      	{
	      	for ( int o = 1; o <= ( pop_inicial - e ); o++ )
	      	{
				if ( avaliacao[ o ] < avaliacao[ o + 1] )
				{
					// Troca avaliacao
					double a = avaliacao[ o ];
					avaliacao[ o ] = avaliacao[ o + 1 ];
					avaliacao[ o + 1 ] = a;

					// Troca u
					a = u[ o ];
					u[ o ] = u[ o + 1 ];
					u[ o + 1 ] = Math.round(Math.round(a));

					// Troca v
					a = v[ o ];
					v[ o ] = v[ o + 1 ];
					v[ o + 1 ] = Math.round(Math.round(a));

					// Troca w
					a = w[ o ];
					w[ o ] = w[ o + 1 ];
					w[ o + 1 ] = Math.round(Math.round(a));

					// Troca x
					a = x[ o ];
					x[ o ] = x[ o + 1 ];
					x[ o + 1 ] = Math.round(Math.round(a));

					// Troca y
					a = y[ o ];
					y[ o ] = y[ o + 1 ];
					y[ o + 1 ] = Math.round(Math.round(a));

					// Troca z
					a = z[ o ];
					z[ o ] = z[ o + 1 ];
					z[ o + 1 ] = Math.round(Math.round(a));

					// Troca intervalo_de
					a = intervalo_de[ o ];
					intervalo_de[ o ] = intervalo_de[ o + 1 ];
					intervalo_de[ o + 1 ] = a;
					
					// Troca intervalo_ate
					a = intervalo_ate[ o ];
					intervalo_ate[ o ] = intervalo_ate[ o + 1 ];
					intervalo_ate[ o + 1 ] = a;
				}
			}
		}

	int aux_posicao;

	int cont_inter = 1;
	
	tot_avaliacoes2 = tot_avaliacoes;

	int pos_inicio_loop_for = 1;
	
	sim1_nao0 = 1;

	while ( cont_inter <= interacoes ) // condição de continuação do loop
	{

		seq_ger++;

		System.out.printf( "+ - + - + - + - + - + - + - + - + - + - + - + - + - + - + - + - +\n" );
		System.out.printf( "GERACAO.: %d\n", seq_ger );
		System.out.printf( "+ - + - + - + - + - + - + - + - + - + - + - + - + - + - + - + - +\n" );

		tot_avaliacoes = tot_avaliacoes2;

		tot_avaliacoes2 = 0;

		int pos_prox_ger = 0;

		String pri_cross = "s";
	
		String cromossomo_ind_1 = "";

      	for ( counter = pos_inicio_loop_for; counter <= individuos; counter++ )
      	{

				double sorteio = Math.random() * tot_avaliacoes;

			aux_posicao = individuos;
			
	      	for ( int counter2 = pos_inicio_loop_for; counter2 <= aux_posicao; counter2++ )
	      	{
				if ( ( sorteio >= intervalo_de[ counter2 ] ) & ( sorteio <= intervalo_ate[ counter2 ] ) )
					 aux_posicao = counter2;
			}
			bin_u[ aux_posicao ] = cromossomo( u[ aux_posicao ], qbits_u ); 

			bin_v[ aux_posicao ] = cromossomo( v[ aux_posicao ], qbits_v ); 

			bin_w[ aux_posicao ] = cromossomo( w[ aux_posicao ], qbits_w ); 

			bin_x[ aux_posicao ] = cromossomo( x[ aux_posicao ], qbits_x ); 

			bin_y[ aux_posicao ] = cromossomo( y[ aux_posicao ], qbits_y ); 

			bin_z[ aux_posicao ] = cromossomo( z[ aux_posicao ], qbits_z ); 

			String cromossomo_ind_2 = bin_u[ aux_posicao ].concat( bin_v[ aux_posicao ].concat( bin_w[ aux_posicao ].concat( bin_x[ aux_posicao ].concat( bin_y[ aux_posicao ].concat( bin_z[ aux_posicao ] ) ) ) ) );

			if ( pri_cross == "s" )
			{
				// muda o flag de pri_cross para "n"
				pri_cross = "n";
				// salva cromossomo do 1o.individuo do par
				cromossomo_ind_1 = cromossomo_ind_2;
			}
			else
			{
				// retorna o flag de pri_cross para "s"
				pri_cross = "s";

				// seleciona o inteiro aleatório para posicao de corte do Gene ( u )  no cromossomo
		        pos_corte_u = aleatorio.nextInt( qbits_u - 1 );

				// seleciona o inteiro aleatório para posicao de corte do Gene ( v )  no cromossomo
		        pos_corte_v = ( qbits_u + 1 ) + aleatorio.nextInt( qbits_v - 1 );

				// seleciona o inteiro aleatório para posicao de corte do Gene ( w )  no cromossomo
		        pos_corte_w = ( qbits_u + qbits_v + 1 ) + aleatorio.nextInt( qbits_w - 1 );

				// seleciona o inteiro aleatório para posicao de corte do Gene ( x )  no cromossomo
		        pos_corte_x = ( qbits_u + qbits_v + qbits_w + 1 ) + aleatorio.nextInt( qbits_x - 1 );

				// seleciona o inteiro aleatório para posicao de corte do Gene ( y )  no cromossomo
		        pos_corte_y = ( qbits_u + qbits_v + qbits_w + qbits_x + 1 ) + aleatorio.nextInt( qbits_y - 1 );

				// seleciona o inteiro aleatório para posicao de corte do Gene ( z )  no cromossomo
		        pos_corte_z = ( qbits_u + qbits_v + qbits_w + qbits_x + qbits_y + 1 ) + aleatorio.nextInt( qbits_z - 1 );

				// EFETUA CROSS OVER - individuo 1
				String aux_lit1 = cromossomo_ind_1.substring( 0, pos_corte_u ).concat( cromossomo_ind_2.substring( pos_corte_u, pos_corte_v) ).concat( cromossomo_ind_1.substring( pos_corte_v, pos_corte_w) ).concat( cromossomo_ind_2.substring( pos_corte_w, pos_corte_x) ).concat( cromossomo_ind_1.substring( pos_corte_x, pos_corte_y) ).concat( cromossomo_ind_2.substring( pos_corte_y, pos_corte_z) ).concat( cromossomo_ind_1.substring( pos_corte_z, cromossomo_ind_1.length()) );

				// EFETUA CROSS OVER - individuo 2
				String aux_lit2 = cromossomo_ind_2.substring( 0, pos_corte_u ).concat( cromossomo_ind_1.substring( pos_corte_u, pos_corte_v) ).concat( cromossomo_ind_2.substring( pos_corte_v, pos_corte_w) ).concat( cromossomo_ind_1.substring( pos_corte_w, pos_corte_x) ).concat( cromossomo_ind_2.substring( pos_corte_x, pos_corte_y) ).concat( cromossomo_ind_1.substring( pos_corte_y, pos_corte_z) ).concat( cromossomo_ind_2.substring( pos_corte_z, cromossomo_ind_2.length()) );

		        sorteio = aleatorio.nextInt( 100 );

			if ( sorteio <= tx_mutacao ) 
			{
		        int pos_mut = aleatorio.nextInt( aux_lit1.length() - 2 ); // aquimutacao

				if ( aux_lit1.substring( pos_mut ).equals( "1" ) )
				{
					aux_lit1 = aux_lit1.substring( 0, pos_mut  ).concat( "0" ).concat( aux_lit1.substring( pos_mut + 1, aux_lit1.length() ) );
				}
				else
				{
					aux_lit1 = aux_lit1.substring( 0, pos_mut ).concat( "1" ).concat(aux_lit1.substring( pos_mut + 1, aux_lit1.length() ) );
				}
			}		
		
		        sorteio = aleatorio.nextInt( 100 );

			if ( sorteio <= tx_mutacao ) 
			{
		        int pos_mut = aleatorio.nextInt( aux_lit2.length() - 2 ); // aquimutacao
				
				if ( aux_lit2.substring( pos_mut ).equals( "1" ) )
				{
					aux_lit2 = aux_lit2.substring( 0, pos_mut ).concat( "0" ).concat( aux_lit2.substring( pos_mut + 1, aux_lit2.length() ) );
				}
				else
				{
					aux_lit2 = aux_lit2.substring( 0, pos_mut ).concat( "1" ).concat(aux_lit2.substring( pos_mut + 1, aux_lit2.length() ) );
				}
			}		
		
				pos_prox_ger++;

				u2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_u, fim_qbits_u ), 2);  
				v2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_v, fim_qbits_v ), 2);  
				w2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_w, fim_qbits_w ), 2);  
				x2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_x, fim_qbits_x ), 2);  
				y2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_y, fim_qbits_y ), 2);  
				z2[ pos_prox_ger ] = Integer.parseInt( aux_lit1.substring( ini_qbits_z, fim_qbits_z ), 2);  

				//(u)
				if ( u2[ pos_prox_ger ] < u_inf )
					u2[ pos_prox_ger ] = u_inf;
				else
					if ( u2[ pos_prox_ger ] > u_sup )
						u2[ pos_prox_ger ] = u_sup;

				//(v)
				if ( v2[ pos_prox_ger ] < v_inf )
					v2[ pos_prox_ger ] = v_inf;
				else
					if ( v2[ pos_prox_ger ] > v_sup )
						v2[ pos_prox_ger ] = v_sup;

				//(w)
				if ( w2[ pos_prox_ger ] < w_inf )
					w2[ pos_prox_ger ] = w_inf;
				else
					if ( w2[ pos_prox_ger ] > w_sup )
						w2[ pos_prox_ger ] = w_sup;

				//(x)
				if ( x2[ pos_prox_ger ] < x_inf )
					x2[ pos_prox_ger ] = x_inf;
				else
					if ( x2[ pos_prox_ger ] > x_sup )
						x2[ pos_prox_ger ] = x_sup;

				//(y)
				if ( y2[ pos_prox_ger ] < y_inf )
					y2[ pos_prox_ger ] = y_inf;
				else
					if ( y2[ pos_prox_ger ] > y_sup )
						y2[ pos_prox_ger ] = y_sup;

				//(z)
				if ( z2[ pos_prox_ger ] < z_inf )
					z2[ pos_prox_ger ] = z_inf;
				else
					if ( z2[ pos_prox_ger ] > z_sup )
						z2[ pos_prox_ger ] = z_sup;

			u_aux = u2[ pos_prox_ger ];
			v_aux = v2[ pos_prox_ger ];
			w_aux = w2[ pos_prox_ger ];
			x_aux = x2[ pos_prox_ger ];
			y_aux = y2[ pos_prox_ger ];
			z_aux = z2[ pos_prox_ger ];
			// ************************************
			u_aux = u_aux / var_maior_dec;
			v_aux = v_aux / var_maior_dec;
			w_aux = w_aux / var_maior_dec;
			x_aux = x_aux / var_maior_dec;
			y_aux = y_aux / var_maior_dec;
			z_aux = z_aux / var_maior_dec;

			// ************************************
			// Normaliza os valores
			// ************************************
			// Replica(0) = 15
			// Fator(1) = 20
			u_aux_n = ( ( u_aux - 50 ) / ( 50 - 40 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			v_aux_n = ( ( v_aux - 40 ) / ( 40 - 20 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			w_aux_n = ( ( w_aux - 7.5 ) / ( 7.5 - 5.0 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			x_aux_n = ( ( x_aux - 1.5 ) / ( 1.5 - 0.5 ) );
			// Replica(0) = 45
			// Fator(1) = 55
			y_aux_n = ( ( y_aux - 60 ) / ( 60 - 30 ) );
			// Replica(0) = 60
			// Fator(1) = 90
			z_aux_n = ( ( z_aux - 2 ) / ( 2 - 1 ) );
		
		 	// EQUACAO DE AVALIACAO (OBJETIVO)
			avaliacao2[ pos_prox_ger ] = Math.abs( 21.2098+1.1576*u_aux_n+1.9929*v_aux_n+0.5279*w_aux_n-1.3504*x_aux_n+1.9462*y_aux_n+6.0507*z_aux_n-0.5191*( Math.pow( u_aux_n, 2 ) )-0.8979*( Math.pow( v_aux_n, 2 ) )-0.2979*( Math.pow( w_aux_n, 2 ) )-0.6904*( Math.pow( x_aux_n, 2 ) )-1.2596*( Math.pow( y_aux_n, 2 ) )-1.2264*( Math.pow( z_aux_n, 2 ) )+0.5792*(u_aux_n*v_aux_n)-0.1998*(u_aux_n*w_aux_n)-0.7289*(u_aux_n*x_aux_n)-2.6617*(u_aux_n*y_aux_n)+0.8850*(u_aux_n*z_aux_n)+0.1362*(v_aux_n*w_aux_n)+0.1345*(v_aux_n*x_aux_n)+0.6864*(v_aux_n*z_aux_n)-0.3035*(w_aux_n*y_aux_n)+0.1613*(w_aux_n*z_aux_n)-0.4896*(x_aux_n*y_aux_n)-0.3572*(x_aux_n*z_aux_n)+0.7686*(y_aux_n*z_aux_n) +0.1211*(u_aux_n*v_aux_n*x_aux_n)-0.3977*(u_aux_n*v_aux_n*y_aux_n)+0.2121*(u_aux_n*v_aux_n*z_aux_n)+0.1933*(u_aux_n*w_aux_n*x_aux_n)+0.4352*(u_aux_n*w_aux_n*y_aux_n)-0.2686*(u_aux_n*w_aux_n*z_aux_n)+0.2004*(u_aux_n*x_aux_n*y_aux_n)-0.3588*(u_aux_n*x_aux_n*z_aux_n)-0.8692*(u_aux_n*y_aux_n*z_aux_n)+0.1811*(v_aux_n*w_aux_n*z_aux_n)+0.1237*(v_aux_n*x_aux_n*y_aux_n)+0.1133*(v_aux_n*y_aux_n*z_aux_n)-0.1898*(w_aux_n*x_aux_n*y_aux_n)-0.3587*(x_aux_n*y_aux_n*z_aux_n)-0.1275*(u_aux_n*v_aux_n*y_aux_n*z_aux_n)-0.3140*(u_aux_n*w_aux_n*x_aux_n*y_aux_n)+0.2638*(u_aux_n*w_aux_n*y_aux_n*z_aux_n)+0.1634*(v_aux_n*w_aux_n*x_aux_n*y_aux_n)-0.1138*(v_aux_n*w_aux_n*x_aux_n*z_aux_n)+0.1381*(u_aux_n*v_aux_n*x_aux_n*y_aux_n*z_aux_n)-0.1027*(u_aux_n*v_aux_n*w_aux_n*y_aux_n*z_aux_n) );

			//Verifica de individuo atingiu o VALOR MINIMO
			if ( avaliacao2[ pos_prox_ger ] >= val_min) 
			{

				// Verifica e Guarda, se valor calculado é melhor que o Valor_Otimo obtido até o momento
				if ( Valor_Otimo_avaliacao < avaliacao2[ pos_prox_ger ] )
				{
					Valor_Otimo_u = u_aux;
					Valor_Otimo_v = v_aux;
					Valor_Otimo_w = w_aux;
					Valor_Otimo_x = x_aux;
					Valor_Otimo_y = y_aux;
					Valor_Otimo_z = z_aux;
					Valor_Otimo_avaliacao = avaliacao2[ pos_prox_ger ];
					Valor_Otimo_geracao = seq_ger;
				}

				out.printf("%d %d %.4f %.4f %.4f %.4f %.4f %.4f %.4f *_ATINGIU_VALOR_MINIMO_*\n",seq_ger,pos_prox_ger,u_aux,v_aux,w_aux,x_aux,y_aux,z_aux,avaliacao2[ pos_prox_ger ]);

				System.out.printf( "# # # # #   V A L O R    M I N I M O    A T I N G I D O   # # # # #\n" ); 
				System.out.printf( "\n INDIVIDUO | Concentracao(x) | Temperatura(y) | Tempo(z) - AVALIACAO\n" ); 
		     	System.out.printf( " %d | %.4f | %.4f | %.4f | %.4f | %.4f | %.4f  =  %.4f\n", counter, u_aux, v_aux, w_aux, x_aux, y_aux, z_aux, avaliacao2[ pos_prox_ger ] ); 

				System.out.print("Deseja continuar? (Sim=1/Nao=0) - # 03 #");
				sim1_nao0 = entrada.nextInt();
				if ( sim1_nao0 == 0)
					break;
			}
			else
			{
				out.printf("%d %d %.4f %.4f %.4f %.4f %.4f %.4f %.4f\n",seq_ger,pos_prox_ger,u_aux,v_aux,w_aux,x_aux,y_aux,z_aux,avaliacao2[ pos_prox_ger ]);

				if ( Valor_Otimo_avaliacao < avaliacao2[ pos_prox_ger ] )
				{
					Valor_Otimo_u = u_aux;
					Valor_Otimo_v = v_aux;
					Valor_Otimo_w = w_aux;
					Valor_Otimo_x = x_aux;
					Valor_Otimo_y = y_aux;
					Valor_Otimo_z = z_aux;
					Valor_Otimo_avaliacao = avaliacao2[ pos_prox_ger ];
					Valor_Otimo_geracao = seq_ger;
				}

			}

			tot_avaliacoes2 += ( avaliacao2[ pos_prox_ger ] + 1 );

			intervalo_de2[ pos_prox_ger ] = intervalo_ate2[ pos_prox_ger - 1 ] + 1;

			intervalo_ate2[ pos_prox_ger ] = intervalo_de[ pos_prox_ger ] + avaliacao2[ pos_prox_ger ];

				pos_prox_ger++;

				u2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_u, fim_qbits_u ), 2);  
				v2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_v, fim_qbits_v ), 2);  
				w2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_w, fim_qbits_w ), 2);  
				x2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_x, fim_qbits_x ), 2);  
				y2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_y, fim_qbits_y ), 2);  
				z2[ pos_prox_ger ] = Integer.parseInt( aux_lit2.substring( ini_qbits_z, fim_qbits_z ), 2);  

				// (u)
				if ( u2[ pos_prox_ger ] < u_inf )
					u2[ pos_prox_ger ] = u_inf;
				else
					if ( u2[ pos_prox_ger ] > u_sup )
						u2[ pos_prox_ger ] = u_sup;

				// (v)
				if ( v2[ pos_prox_ger ] < v_inf )
					v2[ pos_prox_ger ] = v_inf;
				else
					if ( v2[ pos_prox_ger ] > v_sup )
						v2[ pos_prox_ger ] = v_sup;

				// (w)
				if ( w2[ pos_prox_ger ] < w_inf )
					w2[ pos_prox_ger ] = w_inf;
				else
					if ( w2[ pos_prox_ger ] > w_sup )
						w2[ pos_prox_ger ] = w_sup;

				// (x)
				if ( x2[ pos_prox_ger ] < x_inf )
					x2[ pos_prox_ger ] = x_inf;
				else
					if ( x2[ pos_prox_ger ] > x_sup )
						x2[ pos_prox_ger ] = x_sup;

				// (y)
				if ( y2[ pos_prox_ger ] < y_inf )
					y2[ pos_prox_ger ] = y_inf;
				else
					if ( y2[ pos_prox_ger ] > y_sup )
						y2[ pos_prox_ger ] = y_sup;

				// (z)
				if ( z2[ pos_prox_ger ] < z_inf )
					z2[ pos_prox_ger ] = z_inf;
				else
					if ( z2[ pos_prox_ger ] > z_sup )
						z2[ pos_prox_ger ] = z_sup;

			u_aux = u2[ pos_prox_ger ];
			v_aux = v2[ pos_prox_ger ];
			w_aux = w2[ pos_prox_ger ];
			x_aux = x2[ pos_prox_ger ];
			y_aux = y2[ pos_prox_ger ];
			z_aux = z2[ pos_prox_ger ];
			// ************************************
			u_aux = u_aux / var_maior_dec;
			v_aux = v_aux / var_maior_dec;
			w_aux = w_aux / var_maior_dec;
			x_aux = x_aux / var_maior_dec;
			y_aux = y_aux / var_maior_dec;
			z_aux = z_aux / var_maior_dec;

			// ************************************
			// Normaliza os valores
			// ************************************
			// Replica(0) = 15
			// Fator(1) = 20
			u_aux_n = ( ( u_aux - 50 ) / ( 50 - 40 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			v_aux_n = ( ( v_aux - 40 ) / ( 40 - 20 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			w_aux_n = ( ( w_aux - 7.5 ) / ( 7.5 - 5.0 ) );
			// Replica(0) = 15
			// Fator(1) = 20
			x_aux_n = ( ( x_aux - 1.5 ) / ( 1.5 - 0.5 ) );
			// Replica(0) = 45
			// Fator(1) = 55
			y_aux_n = ( ( y_aux - 60 ) / ( 60 - 30 ) );
			// Replica(0) = 60
			// Fator(1) = 90
			z_aux_n = ( ( z_aux - 2 ) / ( 2 - 1 ) );
		
		 	// EQUACAO DE AVALIACAO (OBJETIVO)
			avaliacao2[ pos_prox_ger ] = Math.abs( 21.2098+1.1576*u_aux_n+1.9929*v_aux_n+0.5279*w_aux_n-1.3504*x_aux_n+1.9462*y_aux_n+6.0507*z_aux_n-0.5191*( Math.pow( u_aux_n, 2 ) )-0.8979*( Math.pow( v_aux_n, 2 ) )-0.2979*( Math.pow( w_aux_n, 2 ) )-0.6904*( Math.pow( x_aux_n, 2 ) )-1.2596*( Math.pow( y_aux_n, 2 ) )-1.2264*( Math.pow( z_aux_n, 2 ) )+0.5792*(u_aux_n*v_aux_n)-0.1998*(u_aux_n*w_aux_n)-0.7289*(u_aux_n*x_aux_n)-2.6617*(u_aux_n*y_aux_n)+0.8850*(u_aux_n*z_aux_n)+0.1362*(v_aux_n*w_aux_n)+0.1345*(v_aux_n*x_aux_n)+0.6864*(v_aux_n*z_aux_n)-0.3035*(w_aux_n*y_aux_n)+0.1613*(w_aux_n*z_aux_n)-0.4896*(x_aux_n*y_aux_n)-0.3572*(x_aux_n*z_aux_n)+0.7686*(y_aux_n*z_aux_n) +0.1211*(u_aux_n*v_aux_n*x_aux_n)-0.3977*(u_aux_n*v_aux_n*y_aux_n)+0.2121*(u_aux_n*v_aux_n*z_aux_n)+0.1933*(u_aux_n*w_aux_n*x_aux_n)+0.4352*(u_aux_n*w_aux_n*y_aux_n)-0.2686*(u_aux_n*w_aux_n*z_aux_n)+0.2004*(u_aux_n*x_aux_n*y_aux_n)-0.3588*(u_aux_n*x_aux_n*z_aux_n)-0.8692*(u_aux_n*y_aux_n*z_aux_n)+0.1811*(v_aux_n*w_aux_n*z_aux_n)+0.1237*(v_aux_n*x_aux_n*y_aux_n)+0.1133*(v_aux_n*y_aux_n*z_aux_n)-0.1898*(w_aux_n*x_aux_n*y_aux_n)-0.3587*(x_aux_n*y_aux_n*z_aux_n)-0.1275*(u_aux_n*v_aux_n*y_aux_n*z_aux_n)-0.3140*(u_aux_n*w_aux_n*x_aux_n*y_aux_n)+0.2638*(u_aux_n*w_aux_n*y_aux_n*z_aux_n)+0.1634*(v_aux_n*w_aux_n*x_aux_n*y_aux_n)-0.1138*(v_aux_n*w_aux_n*x_aux_n*z_aux_n)+0.1381*(u_aux_n*v_aux_n*x_aux_n*y_aux_n*z_aux_n)-0.1027*(u_aux_n*v_aux_n*w_aux_n*y_aux_n*z_aux_n) );

			//Verifica de individuo atingiu o VALOR MINIMO
			if ( avaliacao2[ pos_prox_ger ] >= val_min) 
			{

				// Verifica e Guarda, se valor calculado é melhor que o Valor_Otimo obtido até o momento
				if ( Valor_Otimo_avaliacao < avaliacao2[ pos_prox_ger ] )
				{
					Valor_Otimo_u = u_aux;
					Valor_Otimo_v = v_aux;
					Valor_Otimo_w = w_aux;
					Valor_Otimo_x = x_aux;
					Valor_Otimo_y = y_aux;
					Valor_Otimo_z = z_aux;
					Valor_Otimo_avaliacao = avaliacao2[ pos_prox_ger ];
					Valor_Otimo_geracao = seq_ger;
				}

				out.printf("%d %d %.4f %.4f %.4f %.4f %.4f %.4f %.4f *_ATINGIU_VALOR_MINIMO_*\n",seq_ger,pos_prox_ger,u_aux,v_aux,w_aux,x_aux,y_aux,z_aux,avaliacao2[ pos_prox_ger ]);

				System.out.printf( "# # # # #   V A L O R    M I N I M O    A T I N G I D O   # # # # #\n" ); 
				System.out.printf( "\n INDIVIDUO | (u) | (v) | (w) | (x) | (y) | (z) - AVALIACAO\n" ); 
		     	System.out.printf( " %d | %.4f | %.4f | %.4f | %.4f | %.4f | %.4f  =  %.4f\n", counter, u_aux, v_aux, w_aux, x_aux, y_aux, z_aux, avaliacao2[ pos_prox_ger ] ); 

				System.out.print("Deseja continuar? (Sim=1/Nao=0) - # 03 #");
				sim1_nao0 = entrada.nextInt();
				if ( sim1_nao0 == 0)
					break;
			}
			else
			{
				out.printf("%d %d %.4f %.4f %.4f %.4f %.4f %.4f %.4f\n",seq_ger,pos_prox_ger,u_aux,v_aux,w_aux,x_aux,y_aux,z_aux,avaliacao2[ pos_prox_ger ]);

				if ( Valor_Otimo_avaliacao < avaliacao2[ pos_prox_ger ] )
				{
					Valor_Otimo_u = u_aux;
					Valor_Otimo_v = v_aux;
					Valor_Otimo_w = w_aux;
					Valor_Otimo_x = x_aux;
					Valor_Otimo_y = y_aux;
					Valor_Otimo_z = z_aux;
					Valor_Otimo_avaliacao = avaliacao2[ pos_prox_ger ];
					Valor_Otimo_geracao = seq_ger;
				}

			}

			tot_avaliacoes2 += ( avaliacao2[ pos_prox_ger ] + 1 );

			intervalo_de2[ pos_prox_ger ] = intervalo_ate2[ pos_prox_ger - 1 ] + 1;

			intervalo_ate2[ pos_prox_ger ] = intervalo_de[ pos_prox_ger ] + avaliacao2[ pos_prox_ger ];

			}  // fim - ELSE do CROSS OVER
	
		} // fim loop - R O L E T A    V I C I A D A

		if ( sim1_nao0 == 0)
			break;

	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
	System.out.printf( "\nPor favor, aguarde!  Em processo de Elitismo 2...\n");
	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");

      	for ( int e = 1; e <= ( individuos - 1 ); e++ )
      	{
	      	for ( int o = 1; o <= ( individuos - e ); o++ )
	      	{
				if ( avaliacao2[ o ] < avaliacao2[ o + 1] )
				{
					// Troca avaliacao
					double a = avaliacao2[ o ];
					avaliacao2[ o ] = avaliacao2[ o + 1 ];
					avaliacao2[ o + 1 ] = a;

					// Troca u
					a = u2[ o ];
					u2[ o ] = u2[ o + 1 ];
					u2[ o + 1 ] = Math.round(Math.round(a));

					// Troca v
					a = v2[ o ];
					v2[ o ] = v2[ o + 1 ];
					v2[ o + 1 ] = Math.round(Math.round(a));

					// Troca w
					a = w2[ o ];
					w2[ o ] = w2[ o + 1 ];
					w2[ o + 1 ] = Math.round(Math.round(a));

					// Troca x
					a = x2[ o ];
					x2[ o ] = x2[ o + 1 ];
					x2[ o + 1 ] = Math.round(Math.round(a));

					// Troca y
					a = y2[ o ];
					y2[ o ] = y2[ o + 1 ];
					y2[ o + 1 ] = Math.round(Math.round(a));

					// Troca z
					a = z2[ o ];
					z2[ o ] = z2[ o + 1 ];
					z2[ o + 1 ] = Math.round(Math.round(a));

					// Troca intervalo_de
					a = intervalo_de2[ o ];
					intervalo_de2[ o ] = intervalo_de2[ o + 1 ];
					intervalo_de2[ o + 1 ] = a;
					
					// Troca intervalo_ate
					a = intervalo_ate2[ o ];
					intervalo_ate2[ o ] = intervalo_ate2[ o + 1 ];
					intervalo_ate2[ o + 1 ] = a;
				}
			}
		}

      	for ( counter = 1; counter <= individuos - elite; counter++ )
      	{
			// Transfere valor de "u"
         	u[ counter + elite ] =  u2[ counter ];
			// Transfere valor de "v"
         	v[ counter + elite ] =  v2[ counter ];
			// Transfere valor de "w"
         	w[ counter + elite ] =  w2[ counter ];
			// Transfere valor de "x"
         	x[ counter + elite ] =  x2[ counter ];
			// Transfere valor de "y"
         	y[ counter + elite ] =  y2[ counter ];
			// Transfere valor de "z"
         	z[ counter + elite ] =  z2[ counter ];
			// Transfere valor de "avaliacao"
         	avaliacao[ counter + elite ] =  avaliacao2[ counter ];
			// Transfere valor de "intervalo_de"
         	intervalo_de[ counter + elite ] = intervalo_de2[ counter ];
			// Transfere valor de "intervalo_ate"
         	intervalo_ate[ counter + elite ] = intervalo_ate2[ counter ];
		}

		pos_prox_ger = 0;

		tot_avaliacoes = 0;

		cont_inter++;


	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
	System.out.printf( "\nPor favor, aguarde!  Em processo de Elitismo...\n");
	System.out.printf( "\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");

      	for ( int e = 1; e <= ( individuos - 1 ); e++ )
      	{
	      	for ( int o = 1; o <= ( individuos - e ); o++ )
	      	{
				if ( avaliacao[ o ] < avaliacao[ o + 1] )
				{
					// Troca avaliacao
					double a = avaliacao[ o ];
					avaliacao[ o ] = avaliacao[ o + 1 ];
					avaliacao[ o + 1 ] = a;

					// Troca u
					a = u[ o ];
					u[ o ] = u[ o + 1 ];
					u[ o + 1 ] = Math.round(Math.round(a));

					// Troca v
					a = v[ o ];
					v[ o ] = v[ o + 1 ];
					v[ o + 1 ] = Math.round(Math.round(a));

					// Troca w
					a = w[ o ];
					w[ o ] = w[ o + 1 ];
					w[ o + 1 ] = Math.round(Math.round(a));

					// Troca x
					a = x[ o ];
					x[ o ] = x[ o + 1 ];
					x[ o + 1 ] = Math.round(Math.round(a));

					// Troca y
					a = y[ o ];
					y[ o ] = y[ o + 1 ];
					y[ o + 1 ] = Math.round(Math.round(a));

					// Troca z
					a = z[ o ];
					z[ o ] = z[ o + 1 ];
					z[ o + 1 ] = Math.round(Math.round(a));

					// Troca intervalo_de
					a = intervalo_de[ o ];
					intervalo_de[ o ] = intervalo_de[ o + 1 ];
					intervalo_de[ o + 1 ] = a;
					
					// Troca intervalo_ate
					a = intervalo_ate[ o ];
					intervalo_ate[ o ] = intervalo_ate[ o + 1 ];
					intervalo_ate[ o + 1 ] = a;
				}
			}
		}


	}  // fim loop - L O O P I N G   D E   I T E R A C O E S


}		// if ( sim1_nao0 == 1)  // # 02 #

	System.out.printf( "+ - + - + - + - + - + - + - + - + - + - + - + - + - + - + - + - +\n" );
	System.out.printf( "MELHOR AVALIACAO\n");
	System.out.printf( " ( u )......: %.4f\n", Valor_Otimo_u );
	System.out.printf( " ( v )......: %.4f\n", Valor_Otimo_v );
	System.out.printf( " ( w )......: %.4f\n", Valor_Otimo_w );
	System.out.printf( " ( x )......: %.4f\n", Valor_Otimo_x );
	System.out.printf( " ( y )......: %.4f\n", Valor_Otimo_y );
	System.out.printf( " ( z )......: %.4f\n", Valor_Otimo_z );
	System.out.printf( " Corantes - Avaliacao......: %.4f\n", Valor_Otimo_avaliacao );
	System.out.printf( " Geracao...........................: %.4f\n", Valor_Otimo_geracao);
	System.out.printf( "+ - + - + - + - + - + - + - + - + - + - + - + - + - + - + - + - +\n" );

	out.printf( "MELHOR AVALIACAO\n");
	out.printf( " ( u )......: %.4f\n", Valor_Otimo_u );
	out.printf( " ( v )......: %.4f\n", Valor_Otimo_v );
	out.printf( " ( w )......: %.4f\n", Valor_Otimo_w );
	out.printf( " ( x )......: %.4f\n", Valor_Otimo_x );
	out.printf( " ( y )......: %.4f\n", Valor_Otimo_y );
	out.printf( " ( z )......: %.4f\n", Valor_Otimo_z );
	out.printf( " Corantes - Avaliacao......: %.4f\n", Valor_Otimo_avaliacao );
	out.printf( " Geracao...........................: %.4f\n", Valor_Otimo_geracao);

	out.println("/* FIM */");
	out.close();

	} // fim - void main

   public static String cromossomo( int literal_binario, int variavel_do_processo )          
   {                                                              

	      	int MASCARA_x = 1 << variavel_do_processo - 1;

		String literal = "";

	      	for ( int bit = 1; bit <= variavel_do_processo; bit++ ) 
	      	{

			if ( ( literal_binario & MASCARA_x ) == 0 )
				literal = literal.concat( "0" );
			else
				literal = literal.concat( "1" );

	         	literal_binario <<= 1; // desloca o valor uma posição para esquerda
 
	      	} // fim do for

		return literal;

	}

}
