package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return customer"

    request {
        url "/api/customer"
        method GET()
    }

    response {
        status 200
        headers {
            contentType( applicationJson() )
        }
        body( [id: 1L, name: "Petter"] )
    }
}
