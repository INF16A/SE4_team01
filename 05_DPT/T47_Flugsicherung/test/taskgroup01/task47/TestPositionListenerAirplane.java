package taskgroup01.task47;

import org.junit.Assert;
import org.junit.Test;

public class TestPositionListenerAirplane {
    private class TestPositionListener implements IPositionListener {
        private int callsCount = 0;

        @Override
        public void positionChanged(IPositionSpeaker p, int pos, int height) {
            callsCount++;
        }
    }

    private class TestFlightControlObject implements IFlightControl {
        private int callsCount;

        @Override
        public void registerAirplane(IAirplane p) {
            callsCount++;
        }
    }

    @Test
    public void TestFlightControlObjectInitialCounter() {
        TestFlightControlObject flightControlObject = new TestFlightControlObject();
        Assert.assertEquals(0, flightControlObject.callsCount);
    }

    @Test
    public void TestFlightControlObjectCycleCounter() {
        TestFlightControlObject flightControlObject = new TestFlightControlObject();
        flightControlObject.registerAirplane(null);
        Assert.assertEquals(1, flightControlObject.callsCount);
    }

    @Test
    public void TestTestPositionListenerInitialCount() {
        TestPositionListener positionListener = new TestPositionListener();
        Assert.assertEquals(0, positionListener.callsCount);
    }

    @Test
    public void TestTestPositionListenerCycleCount() {
        TestPositionListener positionListener = new TestPositionListener();
        positionListener.positionChanged(null, 0, 0);
        Assert.assertEquals(1, positionListener.callsCount);
    }

    @Test
    public void TestAdd() {
        IFlightControl fc = new TestFlightControlObject();
        Airplane ap = new Airplane(fc, "", 0, new Airport(0));

        TestPositionListener listener = new TestPositionListener();
        Assert.assertEquals(0, listener.callsCount);
        ap.addListener(listener);
        Assert.assertEquals(0, listener.callsCount);
        ap.cycle();
        Assert.assertEquals(1, listener.callsCount);

    }

    @Test
    public void TestRemove() {
        IFlightControl fc = new TestFlightControlObject();
        Airplane ap = new Airplane(fc, "", 0, new Airport(0));

        TestPositionListener listener = new TestPositionListener();
        Assert.assertEquals(0, listener.callsCount);
        ap.addListener(listener);
        ap.cycle();
        ap.removeListener(listener);
        ap.cycle();
        Assert.assertEquals(1, listener.callsCount);

    }
}
