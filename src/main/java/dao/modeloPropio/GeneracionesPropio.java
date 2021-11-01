package dao.modeloPropio;

import dao.modelos.generationNames.ResultsItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class GeneracionesPropio {

    private List<ResultsItem> results;

}
