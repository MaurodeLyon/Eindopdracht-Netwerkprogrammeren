package controller;

import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.JoystickEvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

public class Wiimote implements WiimoteListener {

	private Controller controller;

	private JoystickEvent joystickEvent = null;
	private boolean nunchukConnected = false;

	public Wiimote(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent e) {
		if (nunchukConnected && joystickEvent != null) {
			controller.setMag(joystickEvent.getMagnitude());
			if (joystickEvent.getAngle() < 270 && joystickEvent.getAngle() > 90
					&& joystickEvent.getMagnitude() > 0.15) {
				controller.Down();
			} else if (joystickEvent.getAngle() < 90
					|| joystickEvent.getAngle() > 270
					&& joystickEvent.getMagnitude() > 0.15) {
				controller.Up();
			}
		}
	}

	@Override
	public void onClassicControllerInsertedEvent(
			ClassicControllerInsertedEvent arg0) {

	}

	@Override
	public void onClassicControllerRemovedEvent(
			ClassicControllerRemovedEvent arg0) {

	}

	@Override
	public void onDisconnectionEvent(DisconnectionEvent arg0) {

	}

	@Override
	public void onExpansionEvent(ExpansionEvent e) {
		if (e instanceof NunchukEvent) {
			joystickEvent = ((NunchukEvent) e).getNunchukJoystickEvent();
		}
	}

	@Override
	public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent arg0) {

	}

	@Override
	public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent arg0) {

	}

	@Override
	public void onIrEvent(IREvent arg0) {

	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent e) {

	}

	@Override
	public void onNunchukInsertedEvent(NunchukInsertedEvent e) {
		nunchukConnected = true;
	}

	@Override
	public void onNunchukRemovedEvent(NunchukRemovedEvent e) {
		nunchukConnected = false;
	}

	@Override
	public void onStatusEvent(StatusEvent e) {

	}

}
