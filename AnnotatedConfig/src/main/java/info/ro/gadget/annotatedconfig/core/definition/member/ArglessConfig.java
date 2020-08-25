package info.ro.gadget.annotatedconfig.core.definition.member;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

import info.ro.gadget.annotatedconfig.core.AnnotatedConfig;
import info.ro.gadget.annotatedconfig.core.exception.AcWrongClassException;
import info.ro.gadget.annotatedconfig.core.instance.setter.FieldSetter;

/**
 * 値を持たず、パラメータ名だけ書くようなコンフィグの指定。<br>
 * この値が相手にするのはBoolean型のみである。
 * @author Robert_Ordis
 *
 */
public class ArglessConfig implements AcField {
	
	@Override
	public FieldSetter makeMemberSetter(Class<? extends AnnotatedConfig> clazz, String name, Field field)
			throws AcWrongClassException {
		// TODO Auto-gene// TODO Auto-generated method stub
		String key = clazz.getName() + "[" + name + "]";
		
		
		//クラスの検査。プリミティブならラッパークラスに直したうえで実行。（プリミティブのラッパーはVoidを除いて文字列型から変換できる）
		Class<?> fieldClazz = field.getType();
		
		if(!fieldClazz.equals(Boolean.class) && !fieldClazz.equals(boolean.class)) {
			throw new AcWrongClassException(key, "Member type must be boolean/Boolean.");
		}
		
		//ただし、どのような値をもらったところでTrueしかセットしないため、デシリアライザはStringとなる。
		FieldSetter ret = new FieldSetter(String.class, field, name) {
			@Override
			public void putValueInside(AnnotatedConfig conf, Member member, String name, Object value, String comment)
					throws Exception {
				// TODO Auto-generated method stub
				System.out.println(name+":argless input");
				field.set(conf, true);
			}
			
		};
		return ret;
	}

}