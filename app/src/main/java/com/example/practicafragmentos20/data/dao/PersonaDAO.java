package com.example.practicafragmentos20.data.dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.model.BeneficiaryModel;
import com.example.practicafragmentos20.model.ModelBeneficiario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class PersonaDAO extends BaseDAO {

    private static final String FIELD_NAME_SELECTED = "selecionado";

    public static GetBeneficiaryResponse addAll(GetBeneficiaryResponse modeloPersonaResponde) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        ModelBeneficiario modeloRealm = new ModelBeneficiario();
        modeloRealm =  convertidorResponseToModel(modeloPersonaResponde);
        ModelBeneficiario models;
        models = realm.copyToRealm(modeloRealm);
        realm.commitTransaction();
        //realm.close();
        GetBeneficiaryResponse modeloResponde = convertidorModelToResponse(models);
        return modeloResponde;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static GetBeneficiaryResponse getAll() {
        Realm realm;
        realm = Realm.getDefaultInstance();

        ModelBeneficiario models;

        models = realm.where(ModelBeneficiario.class).findFirst();
        //se convierte a un modelo de respuesta que podamos leer
        GetBeneficiaryResponse modeloResponde = convertidorModelToResponse(models);

        realm.close();

        return modeloResponde;
    }

    /*public static GetBeneficiaryResponse getFirst(GetBeneficiaryResponse modeloPersonaResponde) {
        Realm realm;
        realm = Realm.getDefaultInstance();

        ModelBeneficiario modeloRealm = new ModelBeneficiario();
        modeloRealm =  convertidorResponseToModel(modeloPersonaResponde);
        ModelBeneficiario models;
        models = realm.where(ModelBeneficiario.class).findFirst();

        if (models != null) {
            modeloRealm = models;
        }
        GetBeneficiaryResponse modeloResponde = convertidorModelToResponse(models);
        realm.close();

        return modeloResponde;
    }*/

   /* public List<GetBeneficiaryResponse> update(List<GetBeneficiaryResponse> clientEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<GetBeneficiaryResponse> model = realm.copyToRealmOrUpdate(clientEntity);

        realm.commitTransaction();
        realm.close();

        return model;
    }*/

   /* public static void clear() {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        RealmResults<GetBeneficiaryResponse> results;
        results = realm.where(GetBeneficiaryResponse.class).findAll();

        if (!results.isEmpty()) {
            results.deleteAllFromRealm();
        }

        realm.commitTransaction();
        realm.close();
    }
*/
    //se reciben los datos de realm y se convierte a beneficiario response
    private static GetBeneficiaryResponse convertidorModelToResponse(ModelBeneficiario beneficiaryModel) {
        GetBeneficiaryResponse beneficiaryResponse = new GetBeneficiaryResponse();
        //se setea la lista en el response
        List<GetBeneficiaryResponse.ListaBeneficiario> lista = new ArrayList<>();
        for (BeneficiaryModel beneficiaryModelList : beneficiaryModel.getBeneficiaryModelList()) {
            GetBeneficiaryResponse.ListaBeneficiario getBeneficiaryResponse = new GetBeneficiaryResponse.ListaBeneficiario();
            getBeneficiaryResponse.setNombre(beneficiaryModelList.getNombre());
            getBeneficiaryResponse.setApellidoPaterno(beneficiaryModelList.getApellidoPaterno());
            getBeneficiaryResponse.setApellidoMaterno(beneficiaryModelList.getApellidoMaterno());
            getBeneficiaryResponse.setEdad(beneficiaryModelList.getEdad());
            getBeneficiaryResponse.setCurp(beneficiaryModelList.getCurp());
            getBeneficiaryResponse.setIdParentesco(beneficiaryModelList.getIdParentesco());
            getBeneficiaryResponse.setParentesco(beneficiaryModelList.getParentesco());
            getBeneficiaryResponse.setRfc(beneficiaryModelList.getRfc());
            getBeneficiaryResponse.setPorcentaje(beneficiaryModelList.getPorcentaje());
            lista.add(getBeneficiaryResponse);
        }
        beneficiaryResponse.setListaBeneficiarios(lista);
        return beneficiaryResponse;
    }

    //recibo la respuesta del servicio y se convierte en un objeto de realm, lo convierte a un modelo de datos de realm
    private static ModelBeneficiario convertidorResponseToModel(GetBeneficiaryResponse respuestaServicio) {
        ModelBeneficiario modeloRealm = new ModelBeneficiario();
        RealmList<BeneficiaryModel> realmLista = new RealmList<>();
        for (GetBeneficiaryResponse.ListaBeneficiario objetoFor : respuestaServicio.getListaBeneficiarios()) {
            BeneficiaryModel contenidoDeListaRealm = new BeneficiaryModel();
            contenidoDeListaRealm.setNombre(objetoFor.getNombre());
            contenidoDeListaRealm.setApellidoPaterno(objetoFor.getApellidoPaterno());
            contenidoDeListaRealm.setApellidoMaterno(objetoFor.getApellidoMaterno());
            contenidoDeListaRealm.setEdad(objetoFor.getEdad());
            contenidoDeListaRealm.setCurp(objetoFor.getCurp());
            contenidoDeListaRealm.setRfc(objetoFor.getRfc());
            contenidoDeListaRealm.setParentesco(objetoFor.getParentesco());
            contenidoDeListaRealm.setIdParentesco(objetoFor.getIdParentesco());
            contenidoDeListaRealm.setPorcentaje(objetoFor.getPorcentaje());
            realmLista.add(contenidoDeListaRealm);
        }
        modeloRealm.setOtraVariable("hola");
        modeloRealm.setBeneficiaryModelList(realmLista);

        return modeloRealm;


    }

    /*
    String valor = "un valor";
        int otroValor = 8;

        int suma = 1;
        suma = otroValor;
        unMetodo(valor, otroValor);

    private int unMetodo(String vall1, int val2) {
        String valor;
        valor = "hola";
        return val2;
    }*/
    /*
    public static GetBeneficiaryResponse getSelected() {
        Realm realm;
        realm = Realm.getDefaultInstance();
        //realm.beginTransaction();

        GetBeneficiaryResponse result;
        result = realm.where(GetBeneficiaryResponse.class).equalTo(FIELD_NAME_SELECTED, true).findAll();
       // result = (List<ModeloPersona>) realm.where(ModeloPersona.class).equalTo(FIELD_NAME_SELECTED, true).findFirst();

        GetBeneficiaryResponse entity;

        if (result != null) {
            entity = result;
        } else {
            entity = null;
        }

        return entity;
    }*/


/*
    private static final String FIELD_NAME_SELECTED = "selected";




    public ClientEntity update(ClientEntity clientEntity) {
        Realm realm;
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        ClientModel com.example.practicafragmentos20.model = realm.copyToRealmOrUpdate(ClientModelConverter.convertFromEntity(clientEntity));

        ClientEntity entity = ClientModelConverter.convertFromModel(com.example.practicafragmentos20.model);

        realm.commitTransaction();
        realm.close();

        return entity;
    }







    */
}