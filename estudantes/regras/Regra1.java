package estudantes.regras;

import estudantes.entidades.Documento;
import professor.entidades.Processo;

//processo não pode ter docs de grad e pos simultaneamente
public class Regra1 implements Regra{
    public boolean validate(Processo processo, Documento documento){
        Documento[] docsProcesso = processo.pegarCopiaDoProcesso();

        //verificar se processo está vazio
        if (docsProcesso.length == 0) {
            return true;
        }

        boolean processoContemDocPos = false;
        boolean processoContemDocGrad = false;
        for(Documento doc : docsProcesso){
            if(doc.isPosGrad()){
                processoContemDocPos = true;
                //break -> Quebra assim que achar um documento de Pos
                return processoContemDocPos == documento.isPosGrad();
            }

            if(doc.isGrad()){
                processoContemDocGrad = true;
                //break -> Quebra assim que achar um documento de Grad
                return processoContemDocGrad == documento.isGrad();
            }
        }
        //se o processo contem docs de pos, aceitar apenas docs de pos
        //se não contem, aceitar apenas docs que não sao de pos
        //ou seja, precisam ser iguais
        return true; //Deixa pro compilador não tiltar
        //Caso não tenha nenhum dos 2 tipos, está de acordo com a regra
    }
}
