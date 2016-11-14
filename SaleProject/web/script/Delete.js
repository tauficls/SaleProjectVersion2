function AreYouSure() {
	if (confirm("Apakah kamu yakin mau menghapus barang ini?"))
	{
		if (confirm("Apakah tekad kamu sudah bulat?")) {
			return true;
		} else {
			return false;
		}
		return true;
	} else {
		return false;
	}
}