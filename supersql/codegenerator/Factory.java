package supersql.codegenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import supersql.codegenerator.HTML.HTMLEnv;
import supersql.common.Log;

/**
 * Operator, Manager を生成するクラス
 */
public class Factory implements IFactory {

	private LocalEnv env;
	private LocalEnv env2;
	private String classPrefix;
	private Class[] args = new Class[2];
	
	private void initializeArgs() {
		Class argsClass;
		try {
			argsClass = Class.forName(getClassPrefix() + "Env");
			args[0] = argsClass;
			args[1] = argsClass;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Constructor getConstructor(String postfix) {
		initializeArgs();
		try {
			return Class.forName(getClassPrefix() + postfix).getConstructor(args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Manager createManager() {
		try {
			Constructor managerConstructor = getConstructor("Manager");
			return (Manager) managerConstructor.newInstance(getEnv(), getEnv2());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createLocalEnv() {
	}

	@Override
	public Connector createC0(Manager manager) {
		return null;
	}

	@Override
	public Connector createC1(Manager manager) {
		return null;
	}

	@Override
	public Connector createC2(Manager manager) {
		return null;
	}

	@Override
	public Connector createC3(Manager manager) {
		return null;
	}

	@Override
	public Connector createC4(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG0(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG1(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG2(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG3(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG4(Manager manager) {
		return null;
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return null;
	}

	@Override
	public Function createFunction(Manager manager) {
		return null;
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		return null;
	}

	@Override
	public IfCondition createIfCondition(Manager manager, Attribute condition,
			TFE thenTfe, TFE elseTfe) {
		return null;
	}

/*********************
* Getters and Setters
*********************/
	public LocalEnv getEnv() {
		return env;
	}

	public void setEnv(LocalEnv env) {
		this.env = env;
	}

	public LocalEnv getEnv2() {
		return env2;
	}

	public void setEnv2(LocalEnv env2) {
		this.env2 = env2;
	}

	public String getClassPrefix() {
		return classPrefix;
	}

	public void setClassPrefix(String classPrefix) {
		this.classPrefix = classPrefix;
	}

}
