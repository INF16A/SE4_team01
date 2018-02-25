package task20;

//Leitwarte
class ControlRoom {
    ControlRoom(PowerPlant pp) {
        pp.activateBlock(0);
        pp.activateBlock(1);
        pp.activateBlock(3);
    }
}
