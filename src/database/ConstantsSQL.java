/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Nudista
 */
public interface ConstantsSQL {

    public static final String MAKEROOMTABLE = "CREATE TABLE public.\"Rooms\"\n"
            + "(\n"
            + "  \"Number\" bigint NOT NULL,\n"
            + "  \"Temperature\" double precision,\n"
            + "  \"TargetTemperature\" double precision,\n"
            + "  \"ACmode\" text,\n"
            + "  \"FanMode\" text,\n"
            + "  CONSTRAINT \"Rooms_pkey\" PRIMARY KEY (\"Number\")\n"
            + ")\n"
            + "WITH (\n"
            + "  OIDS=FALSE\n"
            + ");\n"
            + "ALTER TABLE public.\"Rooms\"\n"
            + "  OWNER TO postgres;";
    public static final String INSERT = "INSERT INTO public.\"Rooms\"(\n"
            + "            \"Number\", \"Temperature\", \"TargetTemperature\", \"ACmode\", \"FanMode\")\n"
            + "    VALUES (";
    public static final String UPDATE = "UPDATE public.\"Rooms\"\n"
            + "   SET \"Number\"=?, \"Temperature\"=?, \"TargetTemperature\"=?, \"ACmode\"=?, \n"
            + "       \"FanMode\"=?\n"
            + " WHERE \"Number\"=?;";
}
