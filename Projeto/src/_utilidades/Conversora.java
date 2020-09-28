package _utilidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversora {
	
	
	public String doubleParaString(Double d){
		String str = Double.toString(d);
		return str;
	}
	
	public String asciiParaString (int i){
		String aChar = new Character((char)i).toString();
		return aChar;
	}
	
	public int booleanoParaInteiro(Boolean b){
		int i = (b)?1:0;
		return i;
	}
	
	public String floatParaString(float f){
		String str = Float.toString(f);
		return str;
	}
	
	public Boolean integerParaBooleano(Integer i){
		Boolean b = (i != 0);
		return b;
	}
	public String integerParaString(Integer i){
		String str = Integer.toString(i);
		return str;	
	}
	public String longParaString(long l){
		String str = Long.toString(l);
		return str;
	}
	
	public Double StringParaDouble(String str){
		Double d = Double.valueOf(str).doubleValue();
		return d;
	}
	
	public Integer StringParaInteger(String str){
		int i = Integer.valueOf(str).intValue();
		return i;
	}
	
	public Float StringParaFloat(String str){
		float f = Float.valueOf(str).floatValue();
		return f;
	}
	
	public Long StringParaLong (String str){
		long l = Long.valueOf(str).longValue();
		return l;
	}
	public Date converterStringdata(String data){
		SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
		Date dat = null;
		try {
			dat = new Date(formater.parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dat;
		
	}
	
	public Integer converterParaInteiro(String inteiro){
		Integer per = Integer.parseInt(inteiro);
		return per;
	}
	
	public String converterDataString(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String retorno = sdf.format(data);
		return retorno;
	}
}
