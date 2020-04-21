package strats;
import clans.Terrain;

/**
 * @author humeau
 */
public interface Strategie {
    
    /**
     * @param _plateau
     * @param color
     * @param _colorScore
     * @param _myScore
     * @param _opponentScore
     * @param _opponentMov movement (source, destination) au tour précédent.
     * @param _opponentVillages la liste ordonée des villages construits au tour précédent.
     * @return un tableau de 2 entiers, le 1er sera la source de votre coup, et le second sera la destination
     */
    @Override
    public int[] mouvement( Terrain [] _plateau, int _myColor, int [] _colorScore, int _myScore, int _opponentScore, int [] _opponentMov, int [] _opponentVillages ){
        int[] res= new int[2];
        int nbChoix= Tools.getNbSourceValide(_plateau);                             //on récupère le nb de source valide
        int src= Tools.getSource(_plateau)[rand.nextInt(nbChoix)];               //on en tire une aléatoirement      
        int nbVoisin= Tools.getNbVoisinDispo(_plateau, src);                       //on récupère le nb de voisins de la source
        int dest= Tools.getVoisinsDispo(_plateau, src)[rand.nextInt(nbVoisin)];    //on en tire un aléatoirement
        
        int[] sourcesPossibles = Tools.getSource(_plateau);
        
        boolean scoreMax = scoreMax(_myColor, _colorScore);
        
        
        int bonusPossible = BonusPossible(sourcesPossibles,nbChoix,_plateau,_myColor)[0];
        int n =  BonusPossible(sourcesPossibles,nbChoix,_plateau,_myColor)[1];
        int m =  BonusPossible(sourcesPossibles,nbChoix,_plateau,_myColor)[2];
        
        if(scoreMax){
            if(bonusPossible == 0){
            src= Tools.getSource(_plateau)[rand.nextInt(nbChoix)];               //on en tire une aléatoirement      
            nbVoisin= Tools.getNbVoisinDispo(_plateau, src);                       //on récupère le nb de voisins de la source
            dest= Tools.getVoisinsDispo(_plateau, src)[rand.nextInt(nbVoisin)];    //on en tire un aléatoirement
            }
            else{
                src = n;
                dest= m;   
            }
        }
        else{
            if(bonusPossible == 0){
            src= Tools.getSource(_plateau)[rand.nextInt(nbChoix)];               //on en tire une aléatoirement      
            nbVoisin= Tools.getNbVoisinDispo(_plateau, src);                       //on récupère le nb de voisins de la source
            dest= Tools.getVoisinsDispo(_plateau, src)[rand.nextInt(nbVoisin)];    //on en tire un aléatoirement
        }
            else{
                src = n;
                dest= m;   
            }
        }
        
        
        
        //on retourne notre selection
        res[0]=src;
        res[1]=dest;
        return res;
    }
    
    /**
     * @param _villages
     * @return un tableau correspondant à l'ordre dans laquelle les villages seront créés (si nécessaire)
     */
    @Override
    public int[] ordre( int[] _villages ){
        Random rand = new Random();
        int a,tmp;
        // on melange le tableau des villages
        for (int i=0; i<_villages.length; i++){
            a=rand.nextInt(_villages.length);
            tmp=_villages[a];
            _villages[a]=_villages[i];
            _villages[i]=tmp;
        }
        //on retourne le tableau mélangé
        return _villages;
    }
    
    /**
     * IMPORTANT!!!
     * Remplissez correctement cette méthode avec le bon format expliqué ci-dessous (-2 points si consigne non respectée)
     * @return le nom des élèves (sous le format NOM1 NOM2, ex: "FLEURY MICHON") 
     * NOM1 et NOM2 sont uniquement les noms de famille de votre binome
     * (si nom de famille identique à un autre élève, vous pouvez ajouter l'initiale de votre prénom, ex: A.FLEURY MICHON
     */
    
    public String getName(){
        return "MORIN PARIS VILLETTE CALCOEN";
    }

    /**
     * IMPORTANT!!!
     * Remplissez correctement cette méthode avec le bon format expliqué ci-dessous (-2 points si consigne non respectée)
     * @return le groupe de TD/TP (1, 2, 3, 4, 5, 6 ou P pour les enseignants)
     * Uniquement une lettre ou un chiffre (ex: "1" et surtout pas "groupe 1")
     */    
    public String getGroupe(){
        return "1";
    }
    
    public boolean scoreMax(int _myColor, int[] colorScore){
        for (int i=0; i<colorScore.length; i++){
            if (colorScore[_myColor]<colorScore[i]){
                return false;
            }
          
        }
        return false;
    }
    
    public int[] BonusPossible(int[] sourcesPossibles, int nbChoix, Terrain [] _plateau, int myColor){
        int nb_villages = Tools.countVillage(_plateau); //nombre de villages sur le plateau
        int ere_actuelle = Tools.age(nb_villages);  //age actuel
        int [] q = {0,0, 0};    // pour retour vide au cas où
                            
        for(int i = 0; i< nbChoix; i++){    //On parcours autant de case que possible
            for(int j = 0; j<= 4;j++ ){     //numéro des couleurs
                if(_plateau[sourcesPossibles[i]].getCabanes(j) == myColor){     //Cases qui contiennent mas couleur
                    int nb_voisins = _plateau[sourcesPossibles[i]].getNbVoisins();  //Nombre de voisins de cette case
                    String nature_case = _plateau[sourcesPossibles[i]].getType(); // "foret", "montagne",...
                    for(int k = 0; k< nb_voisins; k++){
                        int voisin = _plateau[sourcesPossibles[i]].getVoisin(k);    //On test chaque voisin un par un
                        boolean voisinEstDispo = test(Tools.getVoisinsDispo(_plateau, sourcesPossibles[i]), voisin);    //On s'assure que le voisin n'est pas une case vide
                        if(voisinEstDispo){
                            String s = _plateau[voisin].getType();
                            if(s.equals("foret") && ere_actuelle <= 4 ){
                                int []t = {1,sourcesPossibles[i], voisin};
                                return t  ;
                            }
                            else if(s.equals("montagne") && ere_actuelle <= 7 && ere_actuelle >=5 ){
                                int [] t = {1,sourcesPossibles[i], voisin};
                                return t  ;
                            }
                            else if(s.equals("champ") && ere_actuelle <= 9 && ere_actuelle >=8){
                                int [] t = {1,sourcesPossibles[i], voisin};
                                return t  ;
                            }
                            else if(s.equals("plaine") && ere_actuelle <= 11 && ere_actuelle >=10){
                                int [] t = {1,sourcesPossibles[i], voisin};
                                return t  ;
                            }
                        }
                    }
                }
            }
            
        }
        return q;
    }
    
    public boolean test(int[] T,int valeurATrouver){
        
         for(int i=0;i<T.length;i++)
        {
            if(T[i]==valeurATrouver)    // On parcours le tableau et on test si la valeur recherchée est présente
            {
                return true;
            }
        }
         return false ;
    }
}
