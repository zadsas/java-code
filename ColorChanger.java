import java.awt.*;
import java.awt.event.*;
import static java.awt.BorderLayout.*;

public class ColorChanger extends Frame {

	private Button redBtn, whiteBtn, blueBtn;
	{
		redBtn = new Button("Red");
		whiteBtn = new Button("White");
		blueBtn = new Button("Blue");
	}

	private static final Color RED, WHITE, BLUE;
	static {
		RED = new Color(255,0,0);
		WHITE = new Color(255,255,255);
		BLUE = new Color(0,0,255);
	}

	private class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String label = e.getActionCommand();
			if(label.equals(redBtn.getLabel())) {
				ColorChanger.this.setBackground(RED);
			} else if(label.equals(whiteBtn.getLabel())) {
				ColorChanger.this.setBackground(WHITE);
			} else if(label.equals(blueBtn.getLabel())) {
				ColorChanger.this.setBackground(BLUE);
			}
		}
	}

	public static Color [] getColors() {
		Color [] colors = {RED, WHITE, BLUE};
		return colors;
	}

	public Button [] getButtons() {
		Button [] buttons = {redBtn, whiteBtn, blueBtn};
		return buttons;
	}

	public ColorChanger(String title) {
		super(title);
		layoutButtons();
		initializeEvents();
		this.setSize(200, 200);
		this.setVisible(true);
	}

	private void initializeEvents() {
		MyButtonListener m = new MyButtonListener();
		redBtn.addActionListener(m);
		whiteBtn.addActionListener(m);
		blueBtn.addActionListener(m);
	}

	protected void layoutButtons() {
		this.setLayout(new BorderLayout());
		this.add(redBtn, NORTH);
		this.add(whiteBtn, SOUTH);
		this.add(blueBtn, WEST);
	}

	public static void main(String [] args) {
		new ColorChanger("Click a button");
	}

}
