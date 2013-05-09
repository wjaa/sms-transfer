package br.com.wjaa.smstransfer.utils;

public class NumberUtil {
	
	public static final Integer getInteger(String value) {
		if ( value == null )
			return null;
		return new Integer( value );
	}
	
	public static final long longValue(Object value) {
		if (value == null)
			return 0L;
		;
		return new Long( value.toString() ).longValue();
	}
	
	
	/**
	 * Verifica se um numero e positivo.
	 * @param v Valor
	 * @return true caso positivo e false caso contrario
	 */
	public static boolean isPositive(Long v){
		return v != null && v > 0;
	}
	
	
	/**
	 * Verifica se um numero e positivo.
	 * @param v Valor
	 * @return true caso positivo e false caso contrario
	 */
	public static boolean isPositive(Integer v){
		return isPositive(v.longValue());
	}
	
	
	/**
	 * Verifica se um numero e positivo.
	 * @param v Valor
	 * @return true caso positivo e false caso contrario
	 */
	public static boolean isPositive(Short s){
		return isPositive(s.longValue());
	}

}
