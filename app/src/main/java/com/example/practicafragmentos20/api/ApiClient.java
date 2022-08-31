package com.example.practicafragmentos20.api;
import com.example.practicafragmentos20.BuildConfig;
import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.api.vo.GetClientDataResponse;
import com.example.practicafragmentos20.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiClient {

    @GET(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_CLIENT_DATA)
    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    Call<GetClientDataResponse> getClientData(
            @Query("numeroCuenta") String accountNumber,
            @Query("curp") String curp,
            @Query("nss") String nss
    );

    //post agregar getBeneficiari response get benficiacy requets
    @POST(Constants.URL_BASE + BuildConfig.PORT_1 + Constants.URN_GET_BENEFICIARY_DATA)
    @Headers({Constants.HTTP_HEADER_AUTHORIZATION})
    Call<GetBeneficiaryResponse> getBeneficiaryData(
            @Body BeneficiaryRequest beneficiary
    );
}
