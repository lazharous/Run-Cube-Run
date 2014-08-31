package it.meltinteractive.game1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
	public boolean jumped;
	
	@Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_SPACE:
        	jumped = true;
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_SPACE:
        	jumped = false;
            break;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
	}
}