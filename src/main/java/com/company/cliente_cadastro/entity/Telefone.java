package com.company.cliente_cadastro.entity;

import com.company.cliente_cadastro.util_interface.TelefoneGenerics;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@Slf4j
public class Telefone implements TelefoneGenerics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

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
