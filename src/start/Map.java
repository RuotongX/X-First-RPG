package start;

public class Map {
	private static int rowMax = 11;
	private static int columnMax = 11;
	private static String[][] map = new String [rowMax][columnMax];
	Player p = new Player();
	public void moveup() {
		p.setRow(p.getRow() - 1);
	}
	public void movedown() {
		p.setRow(p.getRow() + 1);
	}
	public void moveright() {
		p.setColumn(p.getColumn() + 1);
	}
	public void moveleft() {
		p.setColumn(p.getColumn() - 1);
	}
	public void display() {
		for(int i = 0;i<rowMax; i++) {
			for(int j = 0;j<columnMax; j++) {
				if(i == 0||j == 0||i== 10||j == 10) {
					map[i][j] = "*";
			    }
				else if(i==p.getRow() && j == p.getColumn()) {
					map[i][j] = "P" ;
				}
				else {
					map[i][j] = " ";
				}
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public Map() {
	}
}

