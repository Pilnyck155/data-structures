package com.pilnyck.datastructure.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest extends AbstractListTest{

    @Override
    protected List getList() {
        return new ArrayList();
    }
}
