package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//New class to hold a CostedPath object i.e. a list of GraphNodeAL2 objects and a total cost attribute
public class CostedPath{
    public int pathCost=0;
    public List<GraphNodeAL2<?>> pathList=new ArrayList<>();
}