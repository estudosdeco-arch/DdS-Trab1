package estudantes.regras;

import estudantes.entidades.Documento;
import estudantes.entidades.Norma;
import professor.entidades.Processo;
import estudantes.entidades.Portaria;
import estudantes.entidades.Edital;

//portarias e editais VALIDOS não podem ter mais de 100 paginas
//se devolver falso nessa validação, ir para o proximo processo vazio e despachar so com esse documento
public class Regra4 implements Regra{
    public boolean validate(Processo processo, Documento documento){
        if(documento instanceof Portaria || documento instanceof Edital)
            if(((Norma) documento).isValido() && documento.getPaginas() >= 100)//Se é inválido, pode despachar
                return false;

        return true;
    }
}
