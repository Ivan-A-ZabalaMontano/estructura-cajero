package bo.edu.ucb.est;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
	
	
	private Cliente cliente;
	private Cuenta cuenta;
	private ArrayList<Cuenta> cuentas;
	
	
	private String cod;
	private int pin;
	
	
	public Menu()
	{
		Cuenta.agregarCuentas();
		
		mainMenu();
		
		
	}
	public void mainMenu()
	{
		if(inicioSesion())
		{
			accionCuenta();
		}
	}
	public boolean inicioSesion()
	{
		while(true)
		{
			
			cod=JOptionPane.showInputDialog("Codigo de cliente: ");
			String pin2=JOptionPane.showInputDialog("Ingrese su pin: ");
			try
			{
				
					pin=Integer.parseInt(pin2);
					
					
			}catch(NumberFormatException e)
			{
				
			}
			cliente=Cliente.inicioSesion(cod,pin);
			if(cliente!=null)
			{
				return true;
			}
			else
			{
				
				JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos");
				
				
	
			}
		}
	}
	public void accionCuenta()
	{
		for (;true;) {
			String[]menu= {"Ver Saldo","Retirar dinero","Depositar","Salir"};
			String opcion=(String)JOptionPane.showInputDialog(null,"Seleccione la transaccion","Transacciones",
							JOptionPane.DEFAULT_OPTION,null,menu,menu[0]);
			if(opcion.equals("Ver Saldo") || opcion.equals("Retirar dinero") || opcion.equals("Depositar"))
			{
				mostrarCuentas(cod,opcion);
			}
			else
			{
				mainMenu();
			}
		}
	}

	public void mostrarCuentas(String cod, String op) 
	{
		cuentas=Cuenta.getCuentasCliente(cod);
		String [] listaCuentas= new String[cuentas.size()+1];
		System.out.println(cuentas.size());
		for(int i=0;i<cuentas.size();i++) 
		{
			listaCuentas[i]=""+(i+1)+". "+cuentas.get(i).getTipo()+" - "+cuentas.get(i).getNro();
			
		}		
		listaCuentas[cuentas.size()]="Atras";
		for (;true;) {
			
			String opcion=(String)JOptionPane.showInputDialog(null,"Seleccione una cuenta","Cuentas",
							JOptionPane.DEFAULT_OPTION,null,listaCuentas,listaCuentas[0]);
			if(!opcion.equals(null))
			{
				if(opcion.contains("Atras"))
				{
					accionCuenta();
					break;
				}
				int nroCuenta=Integer.parseInt(opcion.split(". ")[0]);
				nroCuenta-=1;
				opcionesCuenta(nroCuenta,op);
			}
		}
	}
	public void opcionesCuenta(int index, String op)
	{
		try
		{
			cuenta=cuentas.get(index);
			if(op.equals("Ver Saldo"))
			{
				JOptionPane.showMessageDialog(null, "Nro de cuenta: "+cuenta.getNro()+
													"\nMoneda: "+cuenta.getMoneda()+
													"\nTipo: "+cuenta.getTipo()+
													"\nSu saldo disponible es: "+cuenta.getSaldo());
				accionCuenta();
			}
			else if(op.equals("Retirar dinero"))
			{
				Double cantidad=Double.parseDouble(JOptionPane.showInputDialog("Su saldo actual es: "+cuenta.getSaldo()+
						"\nIngrese la cantidad que desea retirar en: "+cuenta.getMoneda()));
				cuenta.retiro(cantidad);
				
			}
			else
			{
				Double cantidad=Double.parseDouble(JOptionPane.showInputDialog("Su saldo actual es: "+cuenta.getSaldo()+
						"\nIngrese la cantidad que desea depositar en: "+cuenta.getMoneda()));
				cuenta.deposito(cantidad);
				
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos");
		}
	}
}
