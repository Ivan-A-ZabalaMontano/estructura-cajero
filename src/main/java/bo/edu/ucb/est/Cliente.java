package bo.edu.ucb.est;

public class Cliente {
	
	private String nombre;
	private String codigo;
	private int pin;
	
	public static Cliente []clientes= {new Cliente("Juan Perez","jperez",3333)
									  ,new Cliente("Maria Gomez","mgomez",4444)
									  ,new Cliente("Juan Perez","jperez2",3333)};
	
	//constructor
	private Cliente(String nombre, String codigo, int pin) 
	{
		this.nombre=nombre;
		this.codigo=codigo;
		this.pin=pin;
	}
	//getters
	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPin() {
		return pin;
	}
	//Methods
	public static Cliente inicioSesion(String cod,int pin)
	{
		for(int i=0;i<clientes.length;i++)
		{
			if(cod.equals(clientes[i].getCodigo()))
			{
				if(pin==clientes[i].getPin())
				{
					return clientes[i];
				}
			}
		}
		return null;
	}
	
	
}
