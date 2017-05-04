import java.io.*;
import java.util.*;

public class xmltoprolog_1{
	public static void main(String[] args)throws IOException{
	BufferedReader in =new BufferedReader(new FileReader(new File(args[0])));
	BufferedWriter out=new BufferedWriter(new FileWriter(args[1]));
	int ndstart;
	int zwi;
	int lastk;
	String id="";
	String lon="";
	String lat="";
	String line="";
	int counter=0;
	while((line = in.readLine()) != null){
		counter++;
		if(line.contains("<node")){
			ndstart=line.indexOf("<node");
			id=line.substring(ndstart+10,(lastk=ndstart+16+line.substring(ndstart+16,ndstart+22).indexOf('"')));
			System.out.println("Zeile"+ counter+ "1letztes *"+lastk+"id"+id);
			zwi=lastk+7+line.substring(lastk+7,lastk+22).indexOf('"');
			lat=line.substring(lastk+7,zwi);
			lastk=zwi;
			System.out.println("Zeile"+ counter+ "2letztes *"+lastk+"lat"+lat);
			zwi=lastk+7+line.substring(lastk+7,lastk+22).indexOf('"');
			lon=line.substring(lastk+7,zwi);
			lastk=zwi;
			System.out.println("Zeile"+ counter+ "3letztes *"+lastk+"lon"+lon);
			out.write("node("+id+","+lat+","+lon+").\n");
			}
		}
	out.close();
		
	
	}
}