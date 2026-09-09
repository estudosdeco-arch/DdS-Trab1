package estudantes.regras;

import estudantes.entidades.Ata;
import estudantes.entidades.Documento;
import estudantes.entidades.DocumentoAcademico;
import estudantes.entidades.DocumentoAdministrativo;
import professor.entidades.Processo;

//processo não pode ser despachado apenas com atas
public class Regra3 implements Regra{
    public boolean validate(Processo processo, Documento documento){
        //se não for do tipo ata, não precisa passar pela validaçao
        if(!(documento instanceof Ata)) return true;

        Documento[] docsProcesso = processo.pegarCopiaDoProcesso();

        //se processo esta vazio, pode adicionar -> esta causando erro de apenas atas
        //if(docsProcesso.length == 0) return true;

        //verificar se existem docs de outros tipos no processo
        for(Documento doc : docsProcesso){
            if(!(doc instanceof Ata)){
                return true;
            }
        }

        return false;
    }
}
