package com.unexpected.ant.proto.command;

import com.unexpected.ant.proto.AbstractCommand;
import com.unexpected.ant.proto.ParameterNotFoundException;

/**
 * Help command implementation
 */
public class HelpCommand extends AbstractCommand {
	@Override
	public void execute() throws ParameterNotFoundException {
		getOutput().println("   Parancs                        Leírás");
		getOutput().println("________________________________________________________");
        getOutput().println("exit                       Kilép a programból.");
		getOutput().println("loadMap <mapfile.map>      Betölt egy pályát a <mapfile.map> fájlból, és felépíti.");
        getOutput().println("load <statefile.sav>       Betölt egy játékállapotot a <statefile.sav> fájlból.");
		getOutput().println("save <statefile.sav>       Menti a játék aktuális állapotát a <statefile.sav> fájlba.");
		getOutput().println("step [count]               [count] számú lépést vált ki.");
		getOutput().println("step [EntityID]            Az [EntityID]-ben átadott entitás action() függvényét meghívjuk egyszer.");
		getOutput().println("put [Entity][Cell]         Lerak egy [Entity] típusú entitást a [Cell] cellára.");
		getOutput().println("remove [EntityID]          Letörli az adott [Entity] entitást a térképről.");
		getOutput().println("killerSprayUse [Cell]      Az átadott [Cell]-re fúj egy gyilkoló sprayt.");
		getOutput().println("deodorantSprayUse [Cell]   Alkalmazza az adott cellán a DeodorantSprayt.");
		getOutput().println("getMethods [EntityID]      A megadott ID-jű objektum elérhető metódusait listázza ki.");
		getOutput().println("getStatus [EntityID]       A megadott ID-jű objektum állapotát írja ki, ami az attribútumainak értéke.");
        getOutput().println("[EntityID].[Method] [...]  A megadott ID-jű entitynek meghívjuk a megadott (publikus) metódusát.");
		getOutput().println("getOutput                  Kiírja az aktuális állapotot.");
	}

}
