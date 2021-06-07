package nc.univ.java.model;

public enum SalleEnum {
    A {
        public int getNombreDeSalle() {
            return 10;
        }

        public int getCapacite() {
            return 30;
        }
    },
    F {
        public int getNombreDeSalle() {
            return 6;
        }

        public int getCapacite() {
            return 20;
        }
    },
    E {
        public int getNombreDeSalle() {
            return 6;
        }

        public int getCapacite() {
            return 25;
        }
    },
    L {
        public int getNombreDeSalle() {
            return 45;
        }

        public int getCapacite() {
            return 40;
        }
    };

    abstract public int getNombreDeSalle();

    abstract public int getCapacite();
}
