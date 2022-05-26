package com.apiservi.siseduBackend.utilitarios;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
	
	private final static String DEFAULT_DATE_STRING = "01/01/0001"; 
	
	/**
	 * Convierte una cadena dateAsString con formato "dd/MM/yyyy" a Date 
	 * 
	 * @param dateAsString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateAsString) throws ParseException{
		String format="dd/MM/yyyy";
		return stringToDate(dateAsString, format);
	}
	
	public static Date getDefaultDate() throws ParseException{
		String format="dd/MM/yyyy";
		return stringToDate(DEFAULT_DATE_STRING, format);
	}
	 
	/**
	 * Convierte una cadena "dateAsString" con formato "format" a Date
	 *  
	 * @param dateAsString
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateAsString, String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(dateAsString);
		return date;
	}
	
	public static Date stringToDateSilent(String dateAsString, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date=null;
		try {
			date = sdf.parse(dateAsString);
		} catch (Exception e) {}
		return date;
	}
	
	/**
	 * Convierte un <b>Date</b> a String usando el formato <b>format</b>
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String dateToString(Date date, String format) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateAsString = sdf.format(date);
		return dateAsString;
	}
	
	/**
	 * Convierte un <b>Date</b> a String usando el formato <b>format</b>
	 * si ocurre una excepcion devuelve null
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStringSilent(Date date, String format){
		String dateAsString = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateAsString = sdf.format(date);
		}catch (Exception e) {}
		return dateAsString;
	}
	
	/**
	 * Convierte un <b>Date</b> a String usando el formato <b>format</b>
	 * si ocurre una excepcion devuelve null
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateTimeToStringConFormatoCuscar(Date date){
		String format="yyyy-MM-dd'T'HH:mm:ss";
		return dateToStringSilent(date, format);
	}
	
	public static boolean isNullOrDefaultFormatoSunat(Date date){
		if(date==null){
			return true;
		}
		return isDefaultDate(date);
	}
	
	/**
	 * Compara las fechas de acuerdo a :
	 * 1) nullSafe: Si ambos son null devuelve true
	 * 2) FormatoSunat defecto: devuelve true si date1 es "01/01/0001" y date 2 es null o viceversa.
	 * 3) si no cumple lo anterior compara las 2 fechas usando el formato dd/MM/yyyy  
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean nullSafeOrDefaultFormatoSunatEqualsDate(Date date1, Date date2) {
		if(date1==null&&date2==null){
			return true;
		}else if(date1==null&&date2!=null){
			return isDefaultDate(date2);
		}else if(date1!=null&&date2==null){
			return isDefaultDate(date1);
		}
		try{
			return equalsDate(date1, date2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Compara las fechas de acuerdo a :
	 * 1) nullSafe: Si ambos son null devuelve true
	 * 2) FormatoSunat defecto: devuelve true si date1 es "01/01/0001" y date 2 es null o viceversa.
	 * 3) si no cumple lo anterior compara las 2 fechas usando el formato dd/MM/yyyy HH:mm:ss  
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean nullSafeOrDefaultFormatoSunatEqualsDateTime(Date date1, Date date2) {
		if(date1==null&&date2==null){
			return true;
		}else if(date1==null&&date2!=null){
			return isDefaultDate(date2);
		}else if(date1!=null&&date2==null){
			return isDefaultDate(date1);
		}
		try{
			return equalsDateTime(date1, date2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean nullSafeEqualsDate(Date date1, Date date2){
		if(date1==null&&date2==null){
			return true;
		}else if(date1==null&&date2!=null){
			return false;
		}else if(date1!=null&&date2==null){
			return false;
		}
		try{
			return equalsDate(date1, date2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean equalsDate(Date date1, Date date2) throws ParseException{
		String format = "dd/MM/yyyy";
		return equalsDate(date1, date2, format);
	}
	
	public static boolean equalsDate(Date date1, Date date2, String format) throws ParseException{
		String date1AsString = dateToString(date1, format);
		String date2AsString = dateToString(date2, format);
		return date1AsString.equals(date2AsString);
	}
	
	public static boolean equalsDateTime(Date date1, Date date2) throws ParseException{
		String format = "dd/MM/yyyy HH:mm:ss";
		return equalsDate(date1, date2,format);
	}

	private static String transformadarLongToString(long minutos){
		String signo = "";
		if(minutos<0){
			signo = " - ";
			minutos*=-1;
		}
		if(minutos<60){
			return signo + ""+minutos+"mm";
		}
		
		long horas = minutos/60;
		minutos = minutos%60;
		
		
		if(horas<24){
			return signo + ""+horas+"hh "+minutos+"mm";
		}
		
		long dias = horas/24;
		horas = horas%24;
		
		
		if(dias<30){
			return signo + dias + "DD "+horas+"hh "+minutos+"mm";
		}
		
		long meses = dias/30;
		dias = dias%30;
		
		if(meses<12){
			return signo + meses +"MM "+ dias + "DD "+horas+"hh "+minutos+"mm";
		}
		
		long anios = meses/12;
		meses = meses%12;
		
		return signo + anios+ "AA " + meses +"MM "+ dias + "DD "+horas+"hh "+minutos+"mm";
		
	}
	
	
  public static long daysBetween(Date d1, Date d2){
	  long ONE_HOUR = 60 * 60 * 1000L;
    return ( (d2.getTime() - d1.getTime() + ONE_HOUR) / 
                  (ONE_HOUR * 24));
  }   

	public static Integer getTodayAsInteger(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strToday = sdf.format(  new Timestamp( System.currentTimeMillis() )   );
		return new Integer( strToday );
	}
	
	public static Integer getDateYYYYMMDDAsInteger(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String strDate = sdf.format(date);
		return new Integer( strDate );
	}
	
	public static Integer getCurrentYear(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String strYear = sdf.format(  new Timestamp( System.currentTimeMillis() )   );
		return new Integer( strYear );
	}
	
		
	public static Integer getAnioFromDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		if(date != null)
		{
			return new Integer( sdf.format(date) );
		}
		
		return 0;
	}
	
	public static Date getToday(){
		
		return Calendar.getInstance().getTime();
	} 

	/**
	 * Se compara contra la fecha por defecto 01/01/0001
	 * @param date
	 * @return
	 */
	public static boolean isDefaultDate(Date date){
		String format="dd/MM/yyyy";
		try {
			String dateAsString = dateToString(date, format);
			if(DEFAULT_DATE_STRING.equals(dateAsString))
			{
				return true;
			}
			
		} catch (Exception e) {
		}
		return false;
	}
	
	public static Date getCurrentDateWithoutTime(){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date date = cal.getTime();
		return date;
	}
	
    public static Date addDay(Date date, int dias)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
    
    public static Date addMinutos(Date date, int minutos)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutos);
        return cal.getTime();
    }
    
    public static Date addHour(Date date, int horas)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, horas);
        return cal.getTime();
    }

    public static long diferenciaDias(Date fechaMinuendo, Date fechaSustraendo )  throws ParseException{
	   long dias = dateToTimestamp(fechaMinuendo).getTime( ) - dateToTimestamp(fechaSustraendo).getTime( ); 
	   dias = dias / 1000l / 3600l / 24l; 
	   return dias; 
    }
    public static Timestamp dateToTimestamp(java.util.Date dt)
	{
    	Timestamp outDate = null;
		if( !isNullOrDefaultFormatoSunat(dt))
		{
			outDate = new Timestamp(dt.getTime());
		}
		
		return outDate;
	}	

	public static Date getAnioAsDate(Integer anioManifiesto){
		String anioManifiestoAsString = anioManifiesto.toString();
		String anioManifiestoAsStringCuscar = anioManifiestoAsString;
		if(anioManifiestoAsString.length()<4){
			for (int i = anioManifiestoAsString.length(); i < 4; i++) {
				anioManifiestoAsStringCuscar+="0";
			}
		}
		String dateAsString="01/01/"+anioManifiestoAsStringCuscar;
		return stringToDateSilent(dateAsString,"dd/MM/yyyy");
	}
	
	public static String getHour(Date date){
		StringBuffer hora = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);			
		if(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)).length() == 1){
			hora.append("0");
		}
		hora.append(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)));
		hora.append(":");
		if(String.valueOf(cal.get(Calendar.MINUTE)).length() == 1){
			hora.append("0");
		}
		hora.append(String.valueOf(cal.get(Calendar.MINUTE)));		
        return hora.toString();
	}
	
	public static String getFechaZonaHoraria(Date date, String zona) {
		String lcFecha = "";
		try {
			lcFecha = dateToString(date,"yyyyMMddHHmmss").concat(zona);
		} catch (ParseException e) {
			e.printStackTrace();
	    }
		return lcFecha;
	}
	
	public static String getFechaPeru(Date date) {
		return getFechaZonaHoraria(date,"-0500");
	}
}
