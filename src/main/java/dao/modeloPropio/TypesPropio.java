package dao.modeloPropio;

import dao.modelos.types.MovesItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class TypesPropio {

    private List<MovesItem> moves;
}
