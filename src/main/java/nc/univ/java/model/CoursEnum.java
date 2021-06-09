package nc.univ.java.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CoursEnum {
    Java{
        public List<FormationEnum> getFormationsForCours(){
            return Collections.singletonList(FormationEnum.Licence_Informatique);
        }
    },
    Base_de_Donnees{
        public List<FormationEnum> getFormationsForCours(){
            return Collections.singletonList(FormationEnum.Licence_Informatique);
        }
    },
    Mathematiques{
        public List<FormationEnum> getFormationsForCours(){
            return Arrays.asList(FormationEnum.Licence_Informatique, FormationEnum.Licence_Mathematiques);
        }
    },
    Statistiques{
        public List<FormationEnum> getFormationsForCours(){
            return Arrays.asList(FormationEnum.Licence_Informatique, FormationEnum.Licence_Mathematiques);
        }
    },
    Algorithmie{
        public List<FormationEnum> getFormationsForCours(){
            return Arrays.asList(FormationEnum.Licence_Informatique, FormationEnum.Licence_Mathematiques);
        }
    };

    abstract public List<FormationEnum> getFormationsForCours();
}
