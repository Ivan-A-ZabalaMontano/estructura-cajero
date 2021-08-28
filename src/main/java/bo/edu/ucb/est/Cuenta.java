package bo.edu.ucb.est;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cuenta {
	private String codigo;
	private String moneda;
	private String nro;
	private String tipo;
	private double saldo;
	
	
	public static ArrayList<Cuenta> cuentas= new ArrayList<Cuenta>();
	
	private Cuenta(String codigo,String moneda,String nro, String tipo, double saldo)
	{
		this.codigo=codigo;
		this.moneda=moneda;
		this.nro=nro;
		this.tipo=tipo;
		this.saldo=saldo;
	}
	
	public static void agregarCuentas()
	{
		//Cliente 1
		cuentas.add(new Cuenta("jperez","Bolivianos","111122","Caja de Ahorros",12000));
		cuentas.add(new Cuenta("jperez","USD","112211","Cuenta Corriente",100));
		//Cliente 2
		cuentas.add(new Cuenta("mgomez","Bolivianos","221122","Caja de Ahorros",0));
		//Cliente 3
		cuentas.add(new Cuenta("jperez2","Bolivianos","331122","Caja de Ahorros",100));
		cuentas.add(new Cuenta("jperez2","USD","332211","Cuenta Corriente",1000));
		cuentas.add(new Cuenta("jperez2","Bolivianos","332233","Caja de Ahorros",100000));
	}
	public String getNro() 
	{
		return this.nro;
	}
	public double getSaldo() 
	{
		return this.saldo;
	}
	public String getCodigo() 
	{
		return this.codigo;
	}
	public String getTipo() 
	{
		return this.tipo;
	}
	public String getMoneda()
	{
		return this.moneda;
	}
	public static ArrayList<Cuenta> getCuentasCliente(String cod)
	{
		ArrayList<Cuenta> cuentasCliente= new ArrayList<Cuenta>();
		for(int i=0;i<cuentas.size();i++)
		{
			if(cod.equals(cuentas.get(i).getCodigo()))
			{
				cuentasCliente.add(cuentas.get(i));
			}
		}
		return cuentasCliente;
	}
	
	public void retiro(double cantidad)
	{
		if(evaluarCantidad(cantidad))
		{
			if(cantidad<=getSaldo())
			{
				this.saldo-=cantidad;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No cuenta con suficiente saldo en la cuenta");
			}
		}
		
	}
	public void deposito(double cantidad) 
	{
		if(evaluarCantidad(cantidad))
		{
			this.saldo+=cantidad;
		}
	}
	public boolean evaluarCantidad(double cantidad)
	{
		if(cantidad>0)
		{
			return true;
		}
		JOptionPane.showMessageDialog(null, "El monto ingresado no es valido");
		return false;
	}
}
