import java.util.ArrayList;
import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network net = new Network(3);
		double[] in = new double[2];
		double[] eOut = new double[1];
		for(int a = 0; a <net.layers.length; a++){
			for(int p = 0; p < net.layers[a].nodes.length; p++){
				net.layers[a].nodes[p].num=p;
				net.layers[a].nodes[p].lnum=a;
			}
		}
		ArrayList<Boolean> previous4 = new ArrayList<>();
		double inputs[][] = {{0,0},{0,1},{1,0},{1,1}};
		boolean done= false;
		for(int i = 0; i < 10000000&&!done; i++){
			in = inputs[i%4];
			if(in[0]!=in[1]){
				eOut[0]=1;
			}else{
				eOut[0]=0;
			}
//			eOut[0]=0;
			double out[] = net.run(in, eOut);
//			System.out.println("Guess: "+Math.round(out[0]) +"==" +(int)eOut[0] +"  Output Was: "+ out[0]);
			if(Math.round(out[0])==(int)eOut[0]){
				previous4.add(true);
			}else{
				previous4.add(false);
			}
			boolean nope = false;
			for(int a = 0; a < previous4.size();a++){
				if(!previous4.get(a)){
					nope=true;
				}
				
			}
			if(!nope && previous4.size()>3){
				System.out.println(i + " rounds");
				done=true;
			}
			if(previous4.size()>4){
				previous4.remove(0);
			}
//			System.out.println(i +" "+eOut[0] +" "+ out[0]);
			
			
			
		}
	}

}
