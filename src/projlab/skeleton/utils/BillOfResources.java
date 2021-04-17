package projlab.skeleton.utils;

import projlab.skeleton.resources.Resource;

import java.util.ArrayList;

/**
 * Az építéshez kellő nyersanyagokat tároló objektum
 */
public class BillOfResources {

    /**
     * A szükséges nyersanyagok
     */
    private final ArrayList<Resource> resources = new ArrayList<>();

    /**
     * Hozzáad egy nyersanyagot a listához
     * @param resource A hozzáadandó nyersanyag
     */
    public void addResource(Resource resource) {
        resources.add(resource);
    }

	/**
	 * Ellenőrzi, hogy a megadott lista teljesíti-e a követelményeket
	 * @param incomingResources A meglévő nyersanyagok listája
	 * @return Teljesíti-e a követelményeket a megadott lista
	 */
	public boolean isCompleted(ArrayList<Resource> incomingResources) {
		ArrayList<Resource> res=resources;
		for (Resource inRes: incomingResources) {
			for (int i = 0; i < res.size(); i++) {
				if (inRes.getClass() == res.get(i).getClass()) {
					res.remove(i);
					break;
				}
			}
		}
	    return res.size()==0;
	}
}
