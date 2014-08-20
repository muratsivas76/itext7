package com.itextpdf.core.pdf;

import com.itextpdf.core.exceptions.PdfException;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PdfDictionary extends PdfObject implements Map<PdfName, PdfObject> {

    protected TreeMap<PdfName, PdfObject> map = new TreeMap<PdfName, PdfObject>();

    public PdfDictionary() {
        super(PdfObject.Dictionary);
    }

    public PdfDictionary(PdfDocument doc) {
        super(doc, PdfObject.Dictionary);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public PdfObject get(Object key) {
        return map.get(key);
    }

    @Override
    public PdfObject put(PdfName key, PdfObject value) {
        return map.put(key, value);
    }

    @Override
    public PdfObject remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends PdfName, ? extends PdfObject> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<PdfName> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<PdfObject> values() {
        return map.values();
    }

    @Override
    public Set<Entry<PdfName, PdfObject>> entrySet() {
        return map.entrySet();
    }

    @Override
    protected void flush(PdfWriter writer) throws IOException, PdfException {
        if (flushed)
            return;
        super.flush(writer);
        if (flushed && map != null) {
            clear();
            map = null;
        }
    }

}
