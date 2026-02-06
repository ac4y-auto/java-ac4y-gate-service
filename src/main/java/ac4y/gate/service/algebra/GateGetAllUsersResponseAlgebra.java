package ac4y.gate.service.algebra;

import ac4y.gate.domain.Ac4yUser;
import ac4y.service.domain.Ac4yServiceResponse;

import java.util.List;

public class GateGetAllUsersResponseAlgebra extends Ac4yServiceResponse {

    public List<Ac4yUser> getList() {
        return list;
    }

    public void setList(List<Ac4yUser> list) {
        this.list = list;
    }

    public List<Ac4yUser> list;

}
