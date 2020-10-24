package models;


public class Ville

{
	
    private String ville;
    private int x;
    private int y;

    
 
    
    public Ville(String ville, int x, int y) {
        this.ville = ville;
        this.x = x;
        this.y = y;
    }
    
    public static double getDist(Ville start, Ville end)
    {
        return (end.getX() - start.getX()) + (end.getY() - start.getY());
    }

    double getDist( Ville end)
    {
        return (end.getX() - this.getX()) + (end.getY() - this.getY());
    }

  

    public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}


}
