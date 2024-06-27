package com.company.cliente_cadastro.dto;

import com.company.cliente_cadastro.entity.Telefone;
import com.company.cliente_cadastro.util_interface.TelefoneGenerics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class TelefoneDTO implements TelefoneGenerics {

    public String numero;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof TelefoneGenerics)) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }
}
