package it.maggioli.appalti.rest.utils;

import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEstesoDataAcqCig;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder {

    public static Predicate in(Root<?> root, CriteriaBuilder cb, List<?> inValues, String name) {
        List<List<?>> chunks = toChunk(inValues, 1000);
        Predicate pIn = cb.disjunction();
        chunks.forEach(chunk -> in(root, cb, pIn, chunk, name));
        return pIn;
    }

    private static <T> void in(Root<?> root, CriteriaBuilder cb, Predicate pIn, List<T> chunk, String name) {
        CriteriaBuilder.In<T> inForUffint = cb.in(root.get(name));
        chunk.forEach(inForUffint::value);
        pIn.getExpressions().add(inForUffint);
    }

    public static List<List<?>> toChunk(List<?> list, int chunkSize) {
        List<List<?>> toReturn = new ArrayList<>();

        int numberOfChunk = list.size() / chunkSize;
        int index = -1;
        while (numberOfChunk > index++) {
            int startPoint = chunkSize * index;
            int elemLeft = list.size() - startPoint;
            toReturn.add(list.subList(startPoint, Math.min(elemLeft, chunkSize) + startPoint));
        }

        return toReturn;
    }

}
